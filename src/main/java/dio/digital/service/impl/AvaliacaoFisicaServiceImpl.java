package dio.digital.service.impl;

import dio.digital.error.ResourceNotFoundException;
import dio.digital.repository.AlunoRepository;
import dio.digital.repository.AvaliacaoFisicaRepository;
import dio.digital.entity.Aluno;
import dio.digital.entity.AvaliacaoFisica;
import dio.digital.entity.form.AvaliacaoFisicaForm;
import dio.digital.entity.form.AvaliacaoFisicaUpdateForm;
import dio.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

  @Autowired
  private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
    AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    avaliacaoFisica.setAluno(aluno);
    avaliacaoFisica.setPeso(form.getPeso());
    avaliacaoFisica.setAltura(form.getAltura());

    return avaliacaoFisicaRepository.save(avaliacaoFisica);
  }

  @Override
  public AvaliacaoFisica get(Long id) {
    return avaliacaoFisicaRepository.getById(id);
  }

  @Override
  public List<AvaliacaoFisica> getAll() {

    return avaliacaoFisicaRepository.findAll();
  }

  @Override
  public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
    AvaliacaoFisica fisica = avaliacaoFisicaRepository.findById(id).orElseThrow() ;
    if (fisica != null){
      fisica.setPeso(formUpdate.getPeso());
      fisica.setAltura(formUpdate.getAltura());
      avaliacaoFisicaRepository.save(fisica);
    }
    return fisica;
  }

  @Override
  public void delete(Long id) {
    avaliacaoFisicaRepository.deleteById(id);
  }

  @Override
  public void verifyExistId(Long id){
    if(!avaliacaoFisicaRepository.existsById(id)){
      throw new ResourceNotFoundException("Avaliaçao Fisica not found id: "+id);
    }
  }


}

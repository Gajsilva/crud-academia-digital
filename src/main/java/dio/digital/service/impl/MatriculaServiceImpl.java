package dio.digital.service.impl;

import dio.digital.entity.Aluno;
import dio.digital.entity.Matricula;
import dio.digital.entity.form.MatriculaForm;
import dio.digital.error.ResourceNotFoundException;
import dio.digital.repository.AlunoRepository;
import dio.digital.repository.MatriculaRepository;
import dio.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

  @Autowired
  private MatriculaRepository matriculaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public Matricula create(MatriculaForm form) {
    Matricula matricula = new Matricula();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    matricula.setAluno(aluno);

    return matriculaRepository.save(matricula);
  }

  @Override
  public Matricula get(Long id) {
    return matriculaRepository.findById(id).get();
  }

  @Override
  public List<Matricula> getAll(String bairro) {

    if(bairro == null){
      return matriculaRepository.findAll();
    }else{
      return matriculaRepository.findAlunosMatriculadosBairro(bairro);
    }

  }

  @Override
  public void delete(Long id) {
    matriculaRepository.deleteById(id);
  }

  @Override
  public void verifyExistId(Long id){
    if(!matriculaRepository.existsById(id)){
      throw new ResourceNotFoundException("Matricula not found id: "+id);
    }
  }


}
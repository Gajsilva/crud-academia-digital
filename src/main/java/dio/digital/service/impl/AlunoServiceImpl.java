package dio.digital.service.impl;

import dio.digital.error.ResourceNotFoundException;
import dio.digital.repository.AlunoRepository;
import dio.digital.entity.Aluno;
import dio.digital.entity.AvaliacaoFisica;
import dio.digital.entity.form.AlunoForm;
import dio.digital.entity.form.AlunoUpdateForm;
import dio.digital.infra.utils.JavaTimeUtils;
import dio.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {

  @Autowired
  private AlunoRepository repository;

  @Override
  public Aluno create(AlunoForm form) {
    Aluno aluno = new Aluno();
    aluno.setNome(form.getNome());
    aluno.setCpf(form.getCpf());
    aluno.setBairro(form.getBairro());
    aluno.setDataDeNascimento(form.getDataDeNascimento());

    return repository.save(aluno);
  }

  @Override
  public Aluno get(Long id) {
    return repository.getById(id);
  }

  @Override
  public List<Aluno> getAll(String dataDeNascimento) {

    if(dataDeNascimento == null) {
      return repository.findAll();
    } else {
      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
      return repository.findByDataDeNascimento(localDate);
    }

  }

  @Override
  public Aluno update(Long id, AlunoUpdateForm formUpdate) {
    Optional <Aluno> aluno = Optional.of(repository.findById(id).orElseThrow());
    aluno.get().setNome(formUpdate.getNome());
    aluno.get().setBairro(formUpdate.getBairro());
    aluno.get().setDataDeNascimento(formUpdate.getDataDeNascimento());
    repository.save(aluno.get());
    return aluno.get();
  }

  @Override
  public void delete(Long id) {

    repository.deleteById(id);

  }


  @Override
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

    Aluno aluno = repository.findById(id).get();

    return aluno.getAvaliacoes();

  }
  @Override
  public void verifyExistId(Long id){
    if(!repository.existsById(id)){
        throw new ResourceNotFoundException("Aluno not found id: "+id);
    }
  }


}

package dio.digital.controller;

import dio.digital.entity.form.AlunoUpdateForm;
import dio.digital.error.ResourceNotFoundException;
import dio.digital.repository.AlunoRepository;
import dio.digital.service.impl.AlunoServiceImpl;
import dio.digital.entity.Aluno;
import dio.digital.entity.AvaliacaoFisica;
import dio.digital.entity.form.AlunoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private AlunoServiceImpl service;
  @Autowired
  private AlunoRepository alunoRepository;

  @PostMapping
  public ResponseEntity<?> create(@Valid @RequestBody AlunoForm form) {
    return new ResponseEntity<>(service.create(form), HttpStatus.CREATED);
  }

  @GetMapping("/avaliacoes/{id}")
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    verifyIfExistsId(id);
    return service.getAllAvaliacaoFisicaId(id);
  }
  @GetMapping
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                            String dataDeNacimento){
    return service.getAll(dataDeNacimento);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AlunoUpdateForm form){
    verifyIfExistsId(id);
    return new ResponseEntity<> (service.update(id, form), HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?>  delete(@PathVariable Long id){
    verifyIfExistsId(id);
    service.delete(id);
    return new ResponseEntity<> (HttpStatus.OK);
  }


  private boolean verifyIfExistsId(Long id){
    if (verifyIfExistsId(id))
      throw new ResourceNotFoundException("Aluno not found for id: "+id);

    return false;
  }

}

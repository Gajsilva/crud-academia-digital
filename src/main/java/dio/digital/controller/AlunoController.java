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

  @GetMapping("/{id}")
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    service.verifyExistId(id);
    return service.getAllAvaliacaoFisicaId(id);
  }
  @GetMapping
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                            String dataDeNacimento){
    return service.getAll(dataDeNacimento);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AlunoUpdateForm form){
    service.verifyExistId(id);
    return new ResponseEntity<> (service.update(id, form), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?>  delete(@PathVariable Long id){
    service.verifyExistId(id);
    service.delete(id);
    return new ResponseEntity<> (HttpStatus.OK);
  }




}

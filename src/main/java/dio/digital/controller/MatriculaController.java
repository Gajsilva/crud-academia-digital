package dio.digital.controller;

import dio.digital.entity.Matricula;
import dio.digital.entity.form.MatriculaForm;
import dio.digital.error.ResourceNotFoundException;
import dio.digital.repository.MatriculaRepository;
import dio.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

  @Autowired
  private MatriculaServiceImpl service;
  @Autowired
  private MatriculaRepository matriculaRepository;
  @PostMapping
  public Matricula create(@Valid @RequestBody MatriculaForm form) {
    return service.create(form);
  }

  @GetMapping
  public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
    return service.getAll(bairro);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable long id){
    verifyId(id);
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void verifyId(Long id){
    if(matriculaRepository.findById(id).isEmpty())
      throw new ResourceNotFoundException("Matricula not found for id: "+id);
  }

}


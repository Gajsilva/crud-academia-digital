package dio.digital.controller;

import dio.digital.entity.form.AvaliacaoFisicaUpdateForm;
import dio.digital.error.ResourceNotFoundException;
import dio.digital.repository.AvaliacaoFisicaRepository;
import dio.digital.service.impl.AvaliacaoFisicaServiceImpl;
import dio.digital.entity.AvaliacaoFisica;
import dio.digital.entity.form.AvaliacaoFisicaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

  @Autowired
  private AvaliacaoFisicaServiceImpl service;
  @Autowired
  private AvaliacaoFisicaRepository fisicaRepository;
  @PostMapping
  public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
    return service.create(form);
  }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id){
    verifyIfExistsId(id);
    service.delete(id);
    return new ResponseEntity<> (HttpStatus.OK);
  }
  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm form){
    verifyIfExistsId(id);
    service.update(id, form);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @GetMapping
  public List<AvaliacaoFisica> getAll(){
    return service.getAll();
  }
  @GetMapping("/{id}")
  public ResponseEntity<?> getId(@PathVariable Long id){
    verifyIfExistsId(id);
    service.get(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private void verifyIfExistsId(Long id){
    if (fisicaRepository.findById(id).isEmpty())
      throw new ResourceNotFoundException("Avaliação not found for id: "+id);
  }
}

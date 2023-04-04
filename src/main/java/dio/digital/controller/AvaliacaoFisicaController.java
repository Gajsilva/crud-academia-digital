package dio.digital.controller;

import dio.digital.entity.form.AvaliacaoFisicaUpdateForm;
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

  @PostMapping
  public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
    return service.create(form);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id){
    service.verifyExistId(id);
    service.delete(id);
    return new ResponseEntity<> (HttpStatus.OK);
  }
  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm form){
    service.verifyExistId(id);
    service.update(id, form);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @GetMapping
  public List<AvaliacaoFisica> getAll(){
    return service.getAll();
  }
  @GetMapping("/{id}")
  public ResponseEntity<?> getId(@PathVariable Long id){
    service.verifyExistId(id);
    service.get(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}

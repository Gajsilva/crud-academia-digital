package dio.digital.entity.form;

import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class AlunoUpdateForm {

@NotNull
  private String nome;

  private String bairro;

  private LocalDate dataDeNascimento;

  public String getNome() {
    return nome;
  }

  public String getBairro() {
    return bairro;
  }

  public LocalDate getDataDeNascimento() {
    return dataDeNascimento;
  }
}

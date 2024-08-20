package back;

import java.util.Objects;

public class Matricula {
  private String nome;
  private int[] usuarios;
  private int[] disciplinas;

  public Matricula() {
  }

  public Matricula(String nome, int[] usuarios, int[] disciplinas) {
    this.nome = nome;
    this.usuarios = usuarios;
    this.disciplinas = disciplinas;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int[] getUsuarios() {
    return this.usuarios;
  }

  public void setUsuarios(int[] usuarios) {
    this.usuarios = usuarios;
  }

  public int[] getDisciplinas() {
    return this.disciplinas;
  }

  public void setDisciplinas(int[] disciplinas) {
    this.disciplinas = disciplinas;
  }

  public Matricula nome(String nome) {
    setNome(nome);
    return this;
  }

  public Matricula usuarios(int[] usuarios) {
    setUsuarios(usuarios);
    return this;
  }

  public Matricula disciplinas(int[] disciplinas) {
    setDisciplinas(disciplinas);
    return this;
  }

  public void validarlogin() {

  }

  public void notficarsisco() {

  }

  public void verificardisponibilidade() {

  }

  public void processarmatricula() {

  }

}

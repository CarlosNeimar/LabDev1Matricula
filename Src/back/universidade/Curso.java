package back.universidade;

public class Curso {
  private String nome;
  private int numcreditos;

  // Construtor
  public Curso(String nome, int numcreditos) {
    this.nome = nome;
    this.numcreditos = numcreditos;
  }

  // Get e Set
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNumcreditos() {
    return numcreditos;
  }

  public void setNumcreditos(int numcreditos) {
    this.numcreditos = numcreditos;
  }

  // Métodos
  public void gerenciarDisciplina() {
  }
}

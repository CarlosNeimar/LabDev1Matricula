package back.universidade;

public class Curso {
  private String nome;
  private int numcreditos;
  private Disciplina[] listaDisciplinas;

  // Construtor
  public Curso(String nome, int numcreditos, Disciplina[] listaDisciplinas) {
    this.nome = nome;
    this.numcreditos = numcreditos;
    this.listaDisciplinas = listaDisciplinas;
  }

  // Get e Set
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Disciplina[] getListaDisciplinas() {
    return listaDisciplinas;
  }

  public void setListaDisciplinas(Disciplina[] listaDisciplinas) {
    this.listaDisciplinas = listaDisciplinas;
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

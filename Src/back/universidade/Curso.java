package back.universidade;

public class Curso {
  private String nome;
  private int codigo;
  private int numcreditos;
  private Disciplina[] listaDisciplinas;
  private int preco;

  // Construtor
  public Curso(String nome, int codigo, int numcreditos, Disciplina[] listaDisciplinas, int preco) {
    this.nome = nome;
    this.numcreditos = numcreditos;
    this.listaDisciplinas = listaDisciplinas;
    this.preco = preco;
    this.codigo = codigo;
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

  public int getPreco() {
    return preco;
  }

  public void setPreco(int preco) {
    this.preco = preco;
  }

  public int getNumcreditos() {
    return numcreditos;
  }

  public void setNumcreditos(int numcreditos) {
    this.numcreditos = numcreditos;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  // Métodos
  public void gerenciarDisciplina() {
  }
}

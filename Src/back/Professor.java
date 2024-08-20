package back;
import java.util.Objects;

public class Professor {
  private String nome;
  private int registro;
  private String senha;
  private Disciplina []listadisciplina;


  public Professor() {
  }

  public Professor(String nome, int registro, String senha, Disciplina[] listadisciplina) {
    this.nome = nome;
    this.registro = registro;
    this.senha = senha;
    this.listadisciplina = listadisciplina;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getRegistro() {
    return this.registro;
  }

  public void setRegistro(int registro) {
    this.registro = registro;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Disciplina[] getListadisciplina() {
    return this.listadisciplina;
  }

  public void setListadisciplina(Disciplina[] listadisciplina) {
    this.listadisciplina = listadisciplina;
  }

  public Professor nome(String nome) {
    setNome(nome);
    return this;
  }

  public Professor registro(int registro) {
    setRegistro(registro);
    return this;
  }

  public Professor senha(String senha) {
    setSenha(senha);
    return this;
  }

  public Professor listadisciplina(Disciplina[] listadisciplina) {
    setListadisciplina(listadisciplina);
    return this;
  }

 public void acessarlistaaluno(){

 }

 public void acessarsistema(){
  
 }
}

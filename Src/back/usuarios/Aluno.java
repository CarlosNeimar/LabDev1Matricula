package back.usuarios;
import java.io.Serializable;
import java.util.Objects;

import back.universidade.Universidade;
import back.universidade.Disciplina;

public class Aluno implements Serializable {
  private String nome;
  private int matricula;
  private String senha;
  private Disciplina[] listaDisciplinas;
  private String pergunta;
  private String resposta;

  public Aluno() {
  }

  public Aluno(String nome, int matricula, String senha, Disciplina[] listaDisciplinas, String pergunta, String resposta) {
    this.nome = nome;
    this.matricula = matricula;
    this.senha = senha;
    this.listaDisciplinas = listaDisciplinas;
    this.pergunta = pergunta;
    this.resposta = resposta;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getMatricula() {
    return this.matricula;
  }

  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public void setResposta(String resposta) {
    this.resposta = resposta;
  }

  public String getResposta() {
    return this.resposta;
  }

  public String getPergunta() {
    return this.pergunta;
  }

  public void setPergunta(String pergunta) {
    this.pergunta = pergunta;
  }

  public Disciplina[] getListaDisciplinas() {
    return this.listaDisciplinas;
  }

  public void setListaDisciplinas(Disciplina[] listaDisciplinas) {
    this.listaDisciplinas = listaDisciplinas;
  }

  public Aluno nome(String nome) {
    setNome(nome);
    return this;
  }

  public Aluno matricula(int matricula) {
    setMatricula(matricula);
    return this;
  }

  public Aluno senha(String senha) {
    setSenha(senha);
    return this;
  }

  public Aluno listaDisciplinas(Disciplina[] listaDisciplinas) {
    setListaDisciplinas(listaDisciplinas);
    return this;
  }


  public void matricular() {

  }

  public void cancelarmatricula(){

  }

  public void acessarsit(){

  }

  
  
}

package back.usuarios;

import java.io.Serializable;

import back.universidade.Disciplina;

public class Secretaria implements Serializable {
  private String nome;
  private String senha;
  private int cod;
  private String pergunta;
  private String resposta;
  // Construtor
  public Secretaria(String nome, int cod, String senha, String pergunta, String resposta) {
    this.nome = nome;
    this.cod = cod;
    this.senha = senha;
    this.pergunta = pergunta;
    this.resposta = resposta;
  }

  // Get e Set
  public String getNome() {
    return nome;
  } 

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getPergunta() {
    return this.pergunta;
  }

  public void setPergunta(String pergunta) {
    this.pergunta = pergunta;
  }

  public void setResposta(String resposta) {
    this.resposta = resposta;
  }

  public String getResposta() {
    return this.resposta;
  }
  
  public int getCod() {
    return cod;
  }

  public void setCod(int cod) {
    this.cod = cod;
  }
  
  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
  // Métods
  public void gerarCurriculo(){
  }

  public void cadastrarcurso(String nome, int numcreditos, Disciplina[] listaDisciplinas){
    
  }

}

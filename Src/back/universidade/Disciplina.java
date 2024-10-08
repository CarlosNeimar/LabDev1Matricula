package back.universidade;

import java.io.Serializable;

import back.usuarios.Aluno;
import back.usuarios.Professor;

public class Disciplina implements Serializable{
  private String nome;
  private int codigo;
  private int numCreditos;
  private Professor professor;
  private Aluno []listaAlunos;
  private int numvagas;
  private boolean obrigatoria;
  private int periodo;

  // Construtor
  public Disciplina() {
  }
  public Disciplina(String nome, int codigo, int numCreditos, Professor professor, Aluno[] listaAlunos, int numvagas, boolean obrigatoria, int periodo) {
    this.nome = nome;
    this.codigo = codigo;
    this.numCreditos = numCreditos;
    this.professor = professor;
    this.listaAlunos = listaAlunos;
    this.numvagas = numvagas;
    this.obrigatoria = obrigatoria;
    this.periodo = periodo;
  }

  // Getters e Setters
  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getCodigo() {
    return this.codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public int getNumCreditos() {
    return this.numCreditos;
  }

  public void setNumCreditos(int numCreditos) {
    this.numCreditos = numCreditos;
  }

  public void setobrigatoria(boolean obrigatoria) {
    this.obrigatoria = obrigatoria;
  }

  public boolean getobrigatoria() {
    return this.obrigatoria;
  }

  public Professor getProfessor() {
    return this.professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  public Aluno[] getListaAlunos() {
    return this.listaAlunos;
  }

  public void setListaAlunos(Aluno[] listaAlunos) {
    this.listaAlunos = listaAlunos;
  }

  public int getNumvagas() {
    return this.numvagas;
  }

  public void setNumvagas(int numvagas) {
    this.numvagas = numvagas;
  }

  public int getPeriodo() {
    return this.periodo;
  }

  public void setPeriodo(int periodo) {
    this.periodo = periodo;
  }

  // Métodos
  public void addaluno() {
    
  }

  public void removealuno() {
  }

  public void verificarativacao() {

  }

  public void cancelardisciplina() {
  }
}

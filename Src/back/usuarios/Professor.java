package back.usuarios;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import back.sistema.UsuarioRepository;
import back.universidade.Disciplina;

public class Professor implements Serializable {

  private static UsuarioRepository usuarioRepository = new UsuarioRepository();

  private String nome;
  private int registro;
  private String senha;
  private Disciplina[] listadisciplina;
  private String pergunta;
  private String resposta;

  public Professor() {
  }

  public Professor(String nome, int registro, String senha, Disciplina[] listadisciplina, String pergunta,
      String resposta) {
    this.nome = nome;
    this.registro = registro;
    this.senha = senha;
    this.listadisciplina = listadisciplina;
    this.pergunta = pergunta;
    this.resposta = resposta;
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

  public void acessarlistaaluno() {

  }

  public void acessarsistema() {

  }

  public void verDisciplinas(Professor professor) {
    if (listadisciplina == null) {
      System.out.println("Voce não tem disciplinas cadastradas");
    } else {
      for (Disciplina disciplina : professor.getListadisciplina()) {
        System.out.println("Código: " + disciplina.getCodigo() + " Nome: " + disciplina.getNome());
      }
    }
  }

  public void verAlunos(Professor professor) {
    Scanner scan = new Scanner(System.in);
    if (listadisciplina == null) {
      System.out.println("Voce não tem disciplinas cadastradas");
    } else {
      for (Disciplina disciplina : professor.getListadisciplina()) {
        System.out.println("Código: " + disciplina.getCodigo() + " Nome: " + disciplina.getNome());
      }
    }
    System.out.println("Escolha o codigo da disciplina que deseja ver os alunos:");
    int cod = scan.nextInt();
    List<Aluno> alunos = usuarioRepository.carregarAlunos();
    for (Aluno aluno : alunos) {
      for (Disciplina disciplina : aluno.getListaDisciplinas()) {
        if (cod == disciplina.getCodigo()) {
          System.out.println("Nome: " + aluno.getNome() + " Matricula: " + aluno.getMatricula());
        }
      }
    }
    // for (Disciplina disciplina : professor.getListadisciplina()) {
    //   if (cod == disciplina.getCodigo()) {
    //     for (Aluno aluno : disciplina.getListaAlunos()) {
    //       System.out.println("Nome: " + aluno.getNome() + " Matricula: " + aluno.getMatricula());
    //     }
    //   }
    // }
  }
}

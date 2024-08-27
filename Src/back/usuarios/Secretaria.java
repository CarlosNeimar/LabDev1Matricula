package back.usuarios;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import back.sistema.UsuarioRepository;
import back.universidade.Disciplina;

public class Secretaria implements Serializable {

    private static UsuarioRepository usuarioRepository = new UsuarioRepository();

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
    System.out.println("Quantas disciplinas deseja adicionar ao currículo?");
    Scanner scan = new Scanner(System.in);
    int numDisciplinas = scan.nextInt();
    Disciplina[] listaDisciplinas = new Disciplina[numDisciplinas];
    List<Disciplina> disciplinas = usuarioRepository.carregardispl();
    for (int i = 0; i < numDisciplinas; i++) {
      System.out.println("Digite o nome da disciplina:");
      String nome = scan.next();
      int codigo = disciplinas.size() + 1;
      System.out.println("Digite o número de créditos da disciplina:");
      int numCreditos = scan.nextInt();
      Professor professor = new Professor();
      Aluno[] aluno = new Aluno[0];
      System.out.println("Digite o número de vagas da disciplina:");
      int numvagas = scan.nextInt();
      Disciplina Novadisciplina = new Disciplina(nome, codigo, numCreditos, professor, aluno, numvagas);
      disciplinas.add(Novadisciplina);
    }
    usuarioRepository.salvardispl(disciplinas);
  }
} 

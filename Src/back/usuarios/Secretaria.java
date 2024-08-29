package back.usuarios;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import back.sistema.UsuarioRepository;
import back.universidade.Curso;
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
  public void gerarCurriculo() {
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
      System.out.println("Disciplina é obrigatória ?");
      String tipo = scan.next();
      boolean obrigatoria = tipo.equals("sim") ? true : false;
      System.out.println("Digite o periodo da disciplina:");
      int periodo = scan.nextInt();
      Disciplina Novadisciplina = new Disciplina(nome, codigo, numCreditos, professor, aluno, numvagas, obrigatoria, periodo);
      disciplinas.add(Novadisciplina);
    }
    usuarioRepository.salvardispl(disciplinas);
  }

  public void consultaralunos() {
    System.out.println("Digite o nome do aluno:");
    Scanner scan = new Scanner(System.in);
    String nome = scan.next();
    List<Aluno> alunos = usuarioRepository.carregarAlunos();
    for (Aluno aluno : alunos) {
      if (aluno.getNome().equals(nome)) {
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Disciplinas: " + aluno.getListaDisciplinas());
        break;
      }
    }
  }

  public void atualizaraluno() {
    System.out.println("Digite o nome do aluno:");
    Scanner scan = new Scanner(System.in);
    String nome = scan.next();
    List<Aluno> alunos = usuarioRepository.carregarAlunos();
    for (Aluno aluno : alunos) {
      if (aluno.getNome().equals(nome)) {
        System.out.println("Aluno: " + aluno.getNome() + " Encontrado");
        boolean sair = false;
        while (!sair) {
          System.out.println("Digite o que deseja atualizar:");
          System.out.println("1 - Nome");
          System.out.println("2 - Matrícula");
          System.out.println("3 - Senha");
          System.out.println("4 - Pergunta de segurança");
          System.out.println("5 - Resposta de segurança");
          System.out.println("6 - Sair");
          int opcao = scan.nextInt();
          if (opcao == 6) {
            sair = true;
            break;
          }
          switch (opcao) {
            case 1:
              System.out.println("Digite o novo nome do aluno:");
              String novoNome = scan.next();
              aluno.setNome(novoNome);
              usuarioRepository.salvarAlunos(alunos);
              break;

            case 2:
              System.out.println("Digite a nova matrícula do aluno:");
              int novaMatricula = scan.nextInt();
              aluno.setMatricula(novaMatricula);
              usuarioRepository.salvarAlunos(alunos);
              break;

            case 3:
              System.out.println("Digite a nova senha do aluno:");
              String novaSenha = scan.next();
              aluno.setSenha(novaSenha);
              usuarioRepository.salvarAlunos(alunos);
              break;

            case 4:
              System.out.println("Digite a nova pergunta de segurança do aluno:");
              String novaPergunta = scan.next();
              aluno.setPergunta(novaPergunta);
              usuarioRepository.salvarAlunos(alunos);
              break;

            case 5:
              System.out.println("Digite a nova resposta de segurança do aluno:");
              String novaResposta = scan.next();
              aluno.setResposta(novaResposta);
              usuarioRepository.salvarAlunos(alunos);
              break;

            default:
              System.out.println("Opção inválida.");
              break;
          }
        }
        break;
      }
    }
  }

  public void removeraluno() {
    System.out.println("Digite o nome do aluno:");
    Scanner scan = new Scanner(System.in);
    String nome = scan.next();
    List<Aluno> alunos = usuarioRepository.carregarAlunos();
    for (Aluno aluno : alunos) {
      if (aluno.getNome().equals(nome)) {
        alunos.remove(aluno);
        usuarioRepository.salvarAlunos(alunos);
        System.out.println("Aluno removido com sucesso.");
        break;
      }
    }
  }

  public void cadastraraluno() {
    Scanner scan = new Scanner(System.in);
    List<Aluno> alunos = usuarioRepository.carregarAlunos();
    System.out.println("Digite o nome do aluno:");
    String nome = scan.next();
    int matricula = alunos.size() + 1; // Gerar matrícula sequencial
    System.out.println("Digite a senha do aluno:");
    String senha = scan.next();
    System.out.println("Digite a pergunta de segurança do aluno:");
    String pergunta = scan.next();
    System.out.println("Digite a resposta de segurança do aluno:");
    String resposta = scan.next();
    Aluno novoAluno = new Aluno(nome, matricula, senha,new Disciplina[0], pergunta, resposta);
    alunos.add(novoAluno);
    usuarioRepository.salvarAlunos(alunos);
  }

  public void cadastrarprof() {
    Scanner scan = new Scanner(System.in);
    List<Professor> professores = usuarioRepository.carregarProf();
    System.out.println("Digite o nome do professor:");
    String nome = scan.next();
    int matricula = professores.size() + 1; // Gerar matrícula sequencial
    System.out.println("Digite a senha do professor:");
    String senha = scan.next();
    System.out.println("Digite a pergunta de segurança do professor:");
    String pergunta = scan.next();
    System.out.println("Digite a resposta de segurança do professor:");
    String resposta = scan.next();
    Professor novoProfessor = new Professor(nome, matricula, senha,new Disciplina[0], pergunta, resposta);
    professores.add(novoProfessor);
    usuarioRepository.salvarProf(professores);
  }

  public void cadastrarcurso() {
    Scanner scan = new Scanner(System.in);
    List<Curso> cursos = usuarioRepository.carregarCursos();
    System.out.println("Digite o nome do curso:");
    String nome = scan.next();
    int codigo = cursos.size() + 1; // Gerar código sequencial
    System.out.println("Digite o número de créditos do curso:");
    int numCreditos = scan.nextInt();
    System.out.println("Digite o preço do curso:");
    int preco = scan.nextInt();
    Curso novoCurso = new Curso(nome, codigo, numCreditos, new Disciplina[0], preco);
    cursos.add(novoCurso);
    usuarioRepository.salvarCursos(cursos);
  }
}

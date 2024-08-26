package back;

import java.util.List;
import java.util.Scanner;

import back.usuarios.*;
import back.sistema.UsuarioRepository;
import back.universidade.Disciplina;

public class Main {

  private static UsuarioRepository usuarioRepository = new UsuarioRepository();

  public static void main(String[] args) {
    System.out.println("Sistema de matrícula");
    System.out.println("1 - entrar");
    System.out.println("2 - ver usuarios (dev)");
    System.out.println("3 - recuperar senha");
    Scanner scan = new Scanner(System.in);
    int opcao = scan.nextInt();
    if (opcao == 2) {
      Main main = new Main();
      main.verusuarios();
    } else if (opcao == 3) {
      recuperarSenha(scan);
    } else {
      entrar();
    }
  }

  // Método para teste
  public void verusuarios() {
    System.out.println("TODOS OS USUARIOS CADASTRADOS");
    List<Aluno> alunos = usuarioRepository.carregarAlunos();
    for (Aluno aluno : alunos) {
      System.out.println("Aluno: " + aluno.getNome() + "\nMatricula: " + aluno.getMatricula()
          + "\nSenha: " + aluno.getSenha() + "\nDisciplinas: " + aluno.getListaDisciplinas() + 
          "\nPergunta de segurança:" + aluno.getPergunta() + "\nResposta de segurança:" + aluno.getResposta());
    }
    List<Professor> professores = usuarioRepository.carregarProf();
    for (Professor professor : professores) {
      System.out.println("Professor: " + professor.getNome() + " Registro: " + professor.getRegistro()
          + " Senha: " + professor.getSenha() + " Disciplinas: " + professor.getListadisciplina());
    }
    List<Secretaria> secretarias = usuarioRepository.carregarSecr();
    for (Secretaria secretaria : secretarias) {
      System.out.println("Secretaria: " + secretaria.getNome() + " Cod: " + secretaria.getCod()
          + " Senha: " + secretaria.getSenha());
    }
  }

  public static void entrar() {
    System.out.println("Sistema de matrícula");
    System.out.println("Bem-vindo ao sistema de matrícula da universidade");
    System.out.println("Digite 1 para login");
    System.out.println("Digite 2 para cadastro");
    System.out.println("Digite 3 para recuperar senha");
    Scanner scan = new Scanner(System.in);
    int opcao = scan.nextInt();
    scan.nextLine(); // Consumir quebra de linha
    switch (opcao) {
      case 1:
        login(scan);
        break;
      case 2:
        cadastro(scan);
        break;
      case 3:
        recuperarSenha(scan);
        break;
      default:
        System.out.println("Opção inválida");
        entrar();
        break;
    }
  }

  public static void login(Scanner scan) {
    System.out.println("---Login---");
    System.out.println("Digite o tipo de usuário:");
    System.out.println("Digite 1 para aluno");
    System.out.println("Digite 2 para professor");
    System.out.println("Digite 3 para secretário");
    int tipo = scan.nextInt();
    scan.nextLine(); // Consumir quebra de linha
    System.out.println("Digite o nome de usuário:");
    String nome = scan.nextLine();
    System.out.println("Digite a senha:");
    String senha = scan.nextLine();

    boolean autenticado = false;

    switch (tipo) {
      case 1:
        List<Aluno> alunos = usuarioRepository.carregarAlunos();
        for (Aluno aluno : alunos) {
          if (aluno.getNome().equals(nome) && aluno.getSenha().equals(senha)) {
            autenticado = true;
            System.out.println("Login realizado com sucesso! Bem-vindo, " + aluno.getNome());
            break;
          }
        }
        break;
      case 2:
        List<Professor> professores = usuarioRepository.carregarProf();
        for (Professor professor : professores) {
          if (professor.getNome().equals(nome) && professor.getSenha().equals(senha)) {
            autenticado = true;
            System.out.println("Login realizado com sucesso! Bem-vindo, " + professor.getNome());
            break;
          }
        }
        break;
      case 3:
        List<Secretaria> secretarias = usuarioRepository.carregarSecr();
        for (Secretaria secretaria : secretarias) {
          if (secretaria.getNome().equals(nome) && secretaria.getSenha().equals(senha)) {
            autenticado = true;
            System.out.println("Login realizado com sucesso! Bem-vindo, " + secretaria.getNome());
            break;
          }
        }
        break;
    }

    if (!autenticado) {
      System.out.println("Nome de usuário ou senha incorretos. Tente novamente.");
      entrar();
    }
  }

  public static void cadastro(Scanner scan) {
    System.out.println("---Cadastro---");
    System.out.println("Digite o tipo de usuário:");
    System.out.println("Digite 1 para aluno");
    System.out.println("Digite 2 para professor");
    System.out.println("Digite 3 para secretário");
    int tipo = scan.nextInt();
    scan.nextLine(); // Consumir quebra de linha
    System.out.println("Digite o nome de usuário:");
    String nome = scan.nextLine();
    System.out.println("Digite a senha:");
    String senha = scan.nextLine();
    System.out.println("Digite uma pergunta de segurança:");
    String pergunta = scan.nextLine();
    System.out.println("Digite a resposta para a pergunta de segurança:");
    String resposta = scan.nextLine();
    cadastrodeusuario(tipo, nome, senha, pergunta, resposta);
  }

  public static void cadastrodeusuario(int tipo, String nome, String senha, String pergunta, String resposta) {
    switch (tipo) {
      case 1:
        List<Aluno> alunos = usuarioRepository.carregarAlunos();
        int matricula = alunos.size() + 1; // Gerar matrícula sequencial
        Aluno novoAluno = new Aluno(nome, matricula, senha, new Disciplina[0], pergunta, resposta);
        alunos.add(novoAluno);
        usuarioRepository.salvarAlunos(alunos);
        System.out.println("Aluno cadastrado com sucesso! Número de matrícula: " + matricula);
        break;
      case 2:
        List<Professor> professores = usuarioRepository.carregarProf();
        int registro = professores.size() + 1; // Gerar registro sequencial
        Professor novoProfessor = new Professor(nome, registro, senha, new Disciplina[0], pergunta, resposta);
        professores.add(novoProfessor);
        usuarioRepository.salvarProf(professores);
        System.out.println("Professor cadastrado com sucesso! Número de registro: " + registro);
        break;
      case 3:
        List<Secretaria> secretarias = usuarioRepository.carregarSecr();
        int cod = secretarias.size() + 1; // Gerar código sequencial
        Secretaria novaSecretaria = new Secretaria(nome, cod, senha, pergunta, resposta);
        secretarias.add(novaSecretaria);
        usuarioRepository.salvarSecr(secretarias);
        System.out.println("Secretária cadastrada com sucesso! Código: " + cod);
        break;
    }
    main(null);
  }

  public static void recuperarSenha(Scanner scan) {
    System.out.println("---Recuperação de Senha---");
    System.out.println("Digite o tipo de usuário:");
    System.out.println("Digite 1 para aluno");
    System.out.println("Digite 2 para professor");
    System.out.println("Digite 3 para secretário");
    int tipo = scan.nextInt();
    scan.nextLine(); // Consumir quebra de linha
    System.out.println("Digite o nome de usuário:");
    String nome = scan.nextLine();

    String pergunta = null;
    String respostaCorreta = null;

    switch (tipo) {
      case 1:
        List<Aluno> alunos = usuarioRepository.carregarAlunos();
        for (Aluno aluno : alunos) {
          if (aluno.getNome().equals(nome)) {
            pergunta = aluno.getPergunta();
            respostaCorreta = aluno.getResposta();
            break;
          }
        }
        break;
      case 2:
        List<Professor> professores = usuarioRepository.carregarProf();
        for (Professor professor : professores) {
          if (professor.getNome().equals(nome)) {
            pergunta = professor.getPergunta();
            respostaCorreta = professor.getResposta();
            break;
          }
        }
        break;
      case 3:
        List<Secretaria> secretarias = usuarioRepository.carregarSecr();
        for (Secretaria secretaria : secretarias) {
          if (secretaria.getNome().equals(nome)) {
            pergunta = secretaria.getPergunta();
            respostaCorreta = secretaria.getResposta();
            break;
          }
        }
        break;
    }

    if (pergunta != null) {
      System.out.println("Pergunta de segurança: " + pergunta);
      System.out.println("Digite a resposta:");
      String resposta = scan.nextLine();

      if (resposta.equals(respostaCorreta)) {
        System.out.println("Resposta correta. Agora você pode redefinir sua senha.");
        System.out.println("Digite a nova senha:");
        String novaSenha = scan.nextLine();
        atualizarSenha(tipo, nome, novaSenha);
        System.out.println("Senha redefinida com sucesso!");
      } else {
        System.out.println("Resposta incorreta. Não foi possível redefinir a senha.");
      }
    } else {
      System.out.println("Usuário não encontrado.");
    }

    main(null);
  }

  public static void atualizarSenha(int tipo, String nome, String novaSenha) {
    switch (tipo) {
      case 1:
        List<Aluno> alunos = usuarioRepository.carregarAlunos();
        for (Aluno aluno : alunos) {
          if (aluno.getNome().equals(nome)) {
            aluno.setSenha(novaSenha);
            usuarioRepository.salvarAlunos(alunos);
            break;
          }
        }
        break;
      case 2:
        List<Professor> professores = usuarioRepository.carregarProf();
        for (Professor professor : professores) {
          if (professor.getNome().equals(nome)) {
            professor.setSenha(novaSenha);
            usuarioRepository.salvarProf(professores);
            break;
          }
        }
        break;
      case 3:
        List<Secretaria> secretarias = usuarioRepository.carregarSecr();
        for (Secretaria secretaria : secretarias) {
          if (secretaria.getNome().equals(nome)) {
            secretaria.setSenha(novaSenha);
            usuarioRepository.salvarSecr(secretarias);
            break;
          }
        }
        break;
    }
  }
}

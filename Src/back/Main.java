package back;

import java.util.List;
import java.util.Scanner;

import back.usuarios.*;
import back.sistema.UsuarioRepository;
import back.universidade.Disciplina;

public class Main {

  private static UsuarioRepository usuarioRepository = new UsuarioRepository();

  public static void main(String[] args) {
    System.out.println("");
    System.out.println("======================");
    System.out.println(" Sistema de matrícula ");
    System.out.println("======================");
    System.out.println("");
    System.out.println("** Opções: **");
    System.out.println("[1] Entrar");
    System.out.println("[2] Ver usuarios (dev)");
    System.out.println("");
    System.out.println("Digite uma opção:");
    Scanner scan = new Scanner(System.in);
    int opcao = scan.nextInt();
    switch (opcao) {
      case 1:
        entrar();
        break;

      case 2:
        verusuarios();
        break;

      default:
        System.out.println("");
        System.out.println("== Opção inválida! ==");
        main(null);
        break;
    }
  }

  // Método para teste
  public static void verusuarios() {
    System.out.println("====================");
    System.out.println("Usuários cadastrados");
    System.out.println("====================");
    List<Aluno> alunos = usuarioRepository.carregarAlunos();
    for (Aluno aluno : alunos) {
      System.out.println("Aluno: " + aluno.getNome() + "\nMatricula: " + aluno.getMatricula()
          + "\nSenha: " + aluno.getSenha() + "\nDisciplinas: ");
          aluno.getnomeListaDisciplinasCodigos(aluno);
          System.out.println("\nPergunta de segurança:" + aluno.getPergunta() + "\nResposta de segurança:"
           + aluno.getResposta());
      System.out.println("\n");
    }
    System.out.println("-----------------------------");
    System.out.println("-----------------------------");
    System.out.println("-----------------------------");
    System.out.println("Professores:");
    List<Professor> professores = usuarioRepository.carregarProf();
    for (Professor professor : professores) {
      Disciplina[] disciplinas = professor.getListadisciplina();
      System.out.println("Professor: " + professor.getNome() + "\nRegistro: " + professor.getRegistro()
          + "\nSenha: " + professor.getSenha() + "\nDisciplinas: " + /* professor.getListadisciplina() */
          disciplinas);
      System.out.println("\n");
    }
    System.out.println("-----------------------------");
    System.out.println("-----------------------------");
    System.out.println("-----------------------------");
    System.out.println("Secretaria:");
    List<Secretaria> secretarias = usuarioRepository.carregarSecr();
    for (Secretaria secretaria : secretarias) {
      System.out.println("Secretaria: " + secretaria.getNome() + "\nCod: " + secretaria.getCod()
          + "\nSenha: " + secretaria.getSenha());
      System.out.println("\n");
    }
    System.out.println("-----------------------------");
    System.out.println("-----------------------------");
    System.out.println("-----------------------------");
    System.out.println("Disciplinas cadastradas");
    List<Disciplina> disciplinas = usuarioRepository.carregardispl();
    for (Disciplina disciplina : disciplinas) {
      System.out.println("Disciplina: " + disciplina.getNome() + "\nCódigo: " + 
      disciplina.getCodigo() + "\nCréditos: "
          + disciplina.getNumCreditos() + "\nProfessor: " + disciplina.getProfessor() + "\nAlunos: "
          + disciplina.getListaAlunos() + "\nObrigatoria? " + disciplina.getobrigatoria());
      System.out.println("\n");
    }
    System.out.println("-----------------------------");
    System.out.println("------------DEV--------------");
    System.out.println("Criar tudo automaticamente ? y / n");
    Scanner scan = new Scanner(System.in);
    String opcao = scan.next();
    if ("y".equals(opcao)) {
      criartudo();
    } else {
      main(null);
    }
  }

  // Metodo para criar curso automaticamente
  public static void criartudo() {
    List<Aluno> alunos = usuarioRepository.carregarAlunos();
    for (int i = 0; i < 10; i++) {
      int matricula = alunos.size() + 1; // Gerar matrícula sequencial
      Aluno novoAluno = new Aluno("Aluno" + i, matricula, "123", new Disciplina[0],
       "1+1", "2");
      alunos.add(novoAluno);
      System.out.println("Aluno cadastrado com sucesso! Número de matrícula: " + matricula);
    }
    usuarioRepository.salvarAlunos(alunos);
    List<Professor> professores = usuarioRepository.carregarProf();
    for (int i = 0; i < 10; i++) {
      int registro = professores.size() + 1; // Gerar registro sequencial
      Professor novoProfessor = new Professor("Professor" + i, registro, "123",
       new Disciplina[0], "1+1", "2");
      professores.add(novoProfessor);
      System.out.println("Professor cadastrado com sucesso! Número de registro: " + registro);
    }
    usuarioRepository.salvarProf(professores);
    List<Secretaria> secretarias = usuarioRepository.carregarSecr();
    for (int i = 0; i < 10; i++) {
      int cod = secretarias.size() + 1; // Gerar código sequencial
      Secretaria novaSecretaria = new Secretaria("Secretaria" + i, cod,
       "123", "1+1", "2");
      secretarias.add(novaSecretaria);
      System.out.println("Secretária cadastrada com sucesso! Código: " + cod);
    }
    usuarioRepository.salvarSecr(secretarias);
    List<Disciplina> disciplinas = usuarioRepository.carregardispl();
    for (int i = 0; i < 10; i++) {
      String nome = "Disciplina" + i;
      int codigo = disciplinas.size() + 1;
      int numCreditos = i + 1;
      Professor professor = new Professor();
      Aluno[] aluno = new Aluno[0];
      int numvagas = 50;
      boolean obrigatoria = true;
      int periodo = i;
      Disciplina Novadisciplina = new Disciplina(nome, codigo, numCreditos,
       professor, aluno, numvagas, obrigatoria, periodo);
      disciplinas.add(Novadisciplina);
    }
    usuarioRepository.salvardispl(disciplinas);
    main(null);
  }

  // Método de entrada no sistema
  public static void entrar() {
    System.out.println("");
    System.out.println("===================================================");
    System.out.println(" Bem vindo ao sistema de matrícula da universidade ");
    System.out.println("===================================================");
    System.out.println("");
    System.out.println("** Opções: **");
    System.out.println("[1] Login");
    System.out.println("[2] Cadastro");
    System.out.println("[3] Recuperar senha");
    System.out.println("");
    System.out.println("Digite uma opção:");
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

  // Metodos para login / cadastro / alterar senha
  public static void login(Scanner scan) {
    System.out.println("");
    System.out.println("=======");
    System.out.println(" Login ");
    System.out.println("=======");
    System.out.println("");
    System.out.println("Como voce deseja realizar o login?");
    System.out.println("");
    System.out.println("** Opções: **");
    System.out.println("[1] Aluno");
    System.out.println("[2] Professor");
    System.out.println("[3] Secretário");
    System.out.println("");
    System.out.println("Digite uma opção:");

    int tipo = scan.nextInt();
    scan.nextLine(); // Consumir quebra de linha
    System.out.println("");
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
            System.out.println("");
            System.out.println("Login realizado com sucesso! Bem-vindo, " + aluno.getNome());
            alunosystem(aluno);
            break;
          }
        }
        break;
      case 2:
        List<Professor> professores = usuarioRepository.carregarProf();
        for (Professor professor : professores) {
          if (professor.getNome().equals(nome) && professor.getSenha().equals(senha)) {
            autenticado = true;
            System.out.println("");
            System.out.println("Login realizado com sucesso! Bem-vindo, " + professor.getNome());
            professoresystem(professor);
            break;
          }
        }
        break;
      case 3:
        List<Secretaria> secretarias = usuarioRepository.carregarSecr();
        for (Secretaria secretaria : secretarias) {
          if (secretaria.getNome().equals(nome) && secretaria.getSenha().equals(senha)) {
            autenticado = true;
            System.out.println("");
            System.out.println("Login realizado com sucesso! Bem-vindo, " + secretaria.getNome());
            secretariasystem(secretaria);
            break;
          }
        }
        break;
    }

    if (!autenticado) {
      System.out.println("");
      System.out.println("Nome de usuário ou senha incorretos. Tente novamente.");
      entrar();
    }
  }

  public static void cadastro(Scanner scan) {
    System.out.println("");
    System.out.println("==========");
    System.out.println(" Cadastro ");
    System.out.println("==========");
    System.out.println("");
    System.out.println("Qual o tipo de usuário");
    System.out.println("");
    System.out.println("** Opções: **");
    System.out.println("[1] Aluno");
    System.out.println("[2] Professor");
    System.out.println("[3] Secretário");
    System.out.println("");
    System.out.println("Digite uma opção:");
    int tipo = scan.nextInt();
    scan.nextLine(); // Consumir quebra de linha
    System.out.println("");
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

  public static void cadastrodeusuario(int tipo, String nome, String senha,
   String pergunta, String resposta) {
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
        Professor novoProfessor = new Professor(nome, registro, senha, new Disciplina[0],
         pergunta, resposta);
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

  // métodos para cada tipo de usuário
  private static void secretariasystem(Secretaria secretaria) {
    System.out.println("=====================================================");
    System.out.println("----Tela da secretaria " + secretaria.getNome() + "----");
    System.out.println("=====================================================");
    System.out.println("Menu de opções:");
    System.out.println("1 - Gerar Curriculo");
    System.out.println("2 - Consultar alunos");
    System.out.println("3 - Remover alunos");
    System.out.println("4 - Atualizar dado de aluno");
    System.out.println("5 - Cadastrar Aluno");
    System.out.println("6 - Cadastrar Professor");
    System.out.println("7 - Cadastrar Curso");
    System.out.println("8 - Atribuir Professor a Disciplina");
    System.out.println("Digite a opção desejada:");
    Scanner scan = new Scanner(System.in);
    int opcao = scan.nextInt();
    switch (opcao) {
      case 1:
        secretaria.gerarCurriculo();
        break;

      case 2:
        secretaria.consultaralunos();
        break;

      case 3:
        secretaria.removeraluno();
        break;

      case 4:
        secretaria.atualizaraluno();
        break;

      case 5:
        secretaria.cadastraraluno();
        break;
      case 6:
        secretaria.cadastrarprof();
        break;
      case 7:
        secretaria.cadastrarcurso();
        break;
      case 8:
        secretaria.atribuirprof();
        break;
      default:
        break;
    }
  }

  private static void professoresystem(Professor professor) {
    System.out.println("----Tela do professor----");
    System.out.println("Menu de opções:");
    System.out.println("1 - Ver Disciplinas");
    System.out.println("2 - Ver alunos de disciplina");
    System.out.println("3 - Sair");
    System.out.println("Digite a opção desejada:");
    Scanner scan = new Scanner(System.in);
    int opcao = scan.nextInt();
    switch (opcao) {
      case 1:
        professor.verDisciplinas(professor);
        break;

      case 2:
        professor.verAlunos(professor);
        break;

      case 3:
        System.out.println("Saindo do sistema...");
        break;

      default:
        break;
    }
  }

  private static void alunosystem(Aluno aluno) {
    Scanner scan = new Scanner(System.in);
    boolean sair = false;

    while (!sair) {
      System.out.println("");
      System.out.println("===============");
      System.out.println(" Tela do Aluno ");
      System.out.println("===============");
      System.out.println("");
      System.out.println("** Opções: **");
      System.out.println("");
      System.out.println("[1] Ver Disciplinas");
      System.out.println("[2] Matricular em Disciplina");
      System.out.println("[3] Cancelar Matrícula em Disciplina");
      System.out.println("[4] Ver mensalidade");
      System.out.println("[5] Sair");
      System.out.println("");
      System.out.println("Digite uma opção: ");

      int opcao = scan.nextInt();
      scan.nextLine(); // Consumir quebra de linha

      switch (opcao) {
        case 1:
          aluno.verDisciplinas();
          break;
        case 2:
          List<Disciplina> disciplinasDisponiveis = usuarioRepository.carregardispl(); // Carregar disciplinas do
                                                                                       // repositório

          if (disciplinasDisponiveis.isEmpty()) {
            System.out.println();
            System.out.println("Nenhuma disciplina disponível para matrícula.");
          } else {
            System.out.println();
            System.out.println("Disciplinas disponíveis:");
            for (Disciplina disciplina : disciplinasDisponiveis) {
              System.out.println("- Nome: " + disciplina.getNome() + "\nCódigo: "
               + disciplina.getCodigo() + "\nPeriodo: " + disciplina.getPeriodo());
            }

            System.out.println();
            System.out.println("Digite o código da disciplina para matricular:");
            int codigoMatricula = scan.nextInt();
            scan.nextLine(); // Consumir quebra de linha

            Disciplina disciplinaMatricula = null;
            for (Disciplina disciplina : disciplinasDisponiveis) {
              if (disciplina.getCodigo() == codigoMatricula) {
                disciplinaMatricula = disciplina;
                break;
              }
            }

            if (disciplinaMatricula != null) {
              // Adicionar disciplina à lista de disciplinas do aluno
              int matricula = aluno.getMatricula();
              aluno.matricularDisciplina(disciplinaMatricula, matricula);

              // Atualizar o aluno no repositório
              List<Aluno> alunos = usuarioRepository.carregarAlunos();
              for (int i = 0; i < alunos.size(); i++) {
                if (alunos.get(i).getMatricula() == aluno.getMatricula()) {
                  alunos.set(i, aluno);
                  break;
                }
              }
              usuarioRepository.salvarAlunos(alunos);

              System.out.println("Matrícula realizada com sucesso na disciplina: "
               + disciplinaMatricula.getNome());
            } else {
              System.out.println("Código da disciplina não encontrado.");
            }
          }
          break;
        case 3:
          System.out.println("Digite o código da disciplina para cancelar a matrícula:");
          int codigoCancelamento = scan.nextInt();
          scan.nextLine(); // Consumir quebra de linha
          aluno.cancelarMatricula(codigoCancelamento);

          // Atualizar o aluno no repositório
          List<Aluno> alunos = usuarioRepository.carregarAlunos();
          for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getMatricula() == aluno.getMatricula()) {
              alunos.set(i, aluno);
              break;
            }
          }
          usuarioRepository.salvarAlunos(alunos);

          System.out.println("Matrícula cancelada com sucesso.");
          break;
        case 4:
          aluno.verMensalidade();
          break;
        case 5:
          sair = true;
          System.out.println("Saindo do sistema...");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    }
  }
}

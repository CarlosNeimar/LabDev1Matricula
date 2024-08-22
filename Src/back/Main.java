package back;

import java.util.Scanner;
import back.usuarios.Aluno;

public class Main {
  public static void main(String[] args) {
    System.out.println("Sistema de matricula");
    System.out.println("Bem vindo ao sistema de matricula da universidade");
    login();
  }

  public static void login() {
    System.out.println("Digite 1 para login");
    System.out.println("Digite 2 para cadastro");
    Scanner scan = new Scanner(System.in);
    int opcao = scan.nextInt();
    switch (opcao) {
      case 1:
        System.out.println("---Login---");
        System.out.println("Digite o tipo de usuario:");
        System.out.println("Digite 1 para aluno");
        System.out.println("Digite 2 para professor");
        System.out.println("Digite 3 para secretario");
        int tipo = scan.nextInt();
        System.out.println("---Login---");
        System.out.println("Digite o nome de usuario:");
        String nome = scan.next();
        System.out.println("---Login---");
        System.out.println("Digite a senha:");
        String senha = scan.next();
        break;
      case 2:
        System.out.println("---Cadastro---");
        System.out.println("Digite o tipo de usuario:");
        System.out.println("Digite 1 para aluno");
        System.out.println("Digite 2 para professor");
        System.out.println("Digite 3 para secretario");
        int tipocriar = scan.nextInt();
        System.out.println("---Cadastro---");
        System.out.println("Digite o nome de usuario:");
        String nomecriar = scan.next();
        System.out.println("---Cadastro---");
        System.out.println("Digite a senha:");
        String senhacriar = scan.next();
        break;
      default:
        System.out.println("Opcao invalida");
        login();
        break;
    }
  }

  public static void cadastrodeusuario(int tipo, String nome, String senha) {
    switch (tipo) {
      case 1:
      Aluno aluno = new Aluno();
      aluno.setNome(nome);
      aluno.setSenha(senha);
      
        break;
      case 2:

        break;
      case 3:

        break;
    }

  }
}

package back.sistema;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import back.universidade.Disciplina;
import back.usuarios.*;

public class UsuarioRepository {

  private static final String ALUNO_NAME = "alunos.txt";

  // Salva a lista de alunos em um arquivo
  public void salvarAlunos(List<Aluno> alunos) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ALUNO_NAME))) {
      oos.writeObject(alunos);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Carrega a lista de alunos de um arquivo
  public List<Aluno> carregarAlunos() {
    List<Aluno> alunos = new ArrayList<>();
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ALUNO_NAME))) {
      alunos = (List<Aluno>) ois.readObject();
    } catch (FileNotFoundException e) {
      // Arquivo não existe ainda, retornando lista vazia
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return alunos;
  }

  private static final String PROF_NAME = "professor.txt";

  // Salvar a lista de professores em um arquivo
  public void salvarProf(List<Professor> professores) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PROF_NAME))) {
      oos.writeObject(professores);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Carregar a lista de professores de um arquivo
  public List<Professor> carregarProf() {
    List<Professor> professores = new ArrayList<>();
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PROF_NAME))) {
      professores = (List<Professor>) ois.readObject();
    } catch (FileNotFoundException e) {
      // Arquivo não existe ainda, retornando lista vazia
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return professores;
  }

  private static final String SECR_NAME = "secretaria.txt";

  // Salvar a lista de secretarias em um arquivo
  public void salvarSecr(List<Secretaria> secretarias) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SECR_NAME))) {
      oos.writeObject(secretarias);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Carregar a lista de secretarias de um arquivo
  public List<Secretaria> carregarSecr() {
    List<Secretaria> secretarias = new ArrayList<>();
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SECR_NAME))) {
      secretarias = (List<Secretaria>) ois.readObject();
    } catch (FileNotFoundException e) {
      // Arquivo não existe ainda, retornando lista vazia
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return secretarias;
  }

  private static final String DISPL = "disiplinas.txt";

  // Salvar a lista de disiplinas em um arquivo
  public void salvardispl(List<Disciplina> disciplinas) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DISPL))) {
      oos.writeObject(disciplinas);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Carregar a lista de disiplinas de um arquivo
  public List<Disciplina> carregardispl() {
    List<Disciplina> disiplinas = new ArrayList<>();
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DISPL))) {
      disiplinas = (List<Disciplina>) ois.readObject();
    } catch (FileNotFoundException e) {
      // Arquivo não existe ainda, retornando lista vazia
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return disiplinas;
  }
}

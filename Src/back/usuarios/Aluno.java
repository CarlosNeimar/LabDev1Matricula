package back.usuarios;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.List;

import back.sistema.UsuarioRepository;
import back.universidade.Disciplina;

public class Aluno implements Serializable {

      private static UsuarioRepository usuarioRepository = new UsuarioRepository();

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

    public String getResposta() {
        return this.resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
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

    // Método para visualizar as disciplinas do aluno
    public void verDisciplinas() {
        if (listaDisciplinas.length == 0) {
            System.out.println("Você não está matriculado em nenhuma disciplina.");
        } else {
            System.out.println("Disciplinas em que você está matriculado:");
            for (Disciplina disciplina : listaDisciplinas) {
                System.out.println("Código: " + disciplina.getCodigo() + " Nome: " + disciplina.getNome());
            }
        }
    }

    // Método para matricular o aluno em uma disciplina
    public void matricularDisciplina(Disciplina disciplina, int matricula) {
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }
        // Verificar se o aluno já está matriculado na disciplina
        for (Disciplina d : listaDisciplinas) {
            if (d.getCodigo() == disciplina.getCodigo()) {
                System.out.println("Você já está matriculado nesta disciplina.");
                return;
            }
        }

        List<Aluno> alunos = usuarioRepository.carregarAlunos();
        
        for (Aluno aluno : alunos) {
            if (Integer.valueOf(aluno.getMatricula()).equals(matricula)) {
              aluno.setListaDisciplinas(listaDisciplinas);
              usuarioRepository.salvarAlunos(alunos);
              break;
            }
          }


        // Adicionar a nova disciplina
        Disciplina[] novasDisciplinas = Arrays.copyOf(listaDisciplinas, listaDisciplinas.length + 1);
        novasDisciplinas[novasDisciplinas.length - 1] = disciplina;
        setListaDisciplinas(novasDisciplinas);
        System.out.println("Matricula realizada com sucesso na disciplina " + disciplina.getNome());
        
    }

    // Método para cancelar a matrícula em uma disciplina
    public void cancelarMatricula(int codigoDisciplina) {
        int index = -1;
        for (int i = 0; i < listaDisciplinas.length; i++) {
            if (listaDisciplinas[i].getCodigo() == codigoDisciplina) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Você não está matriculado nesta disciplina.");
            return;
        }

        // Remover a disciplina do array
        Disciplina[] novasDisciplinas = new Disciplina[listaDisciplinas.length - 1];
        for (int i = 0, j = 0; i < listaDisciplinas.length; i++) {
            if (i != index) {
                novasDisciplinas[j++] = listaDisciplinas[i];
            }
        }
        setListaDisciplinas(novasDisciplinas);
        System.out.println("Matrícula cancelada com sucesso na disciplina com código " + codigoDisciplina);
    }
}

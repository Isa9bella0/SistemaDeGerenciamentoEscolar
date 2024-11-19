import java.util.ArrayList;
import java.util.List;

public class GerenciadorCadastroAluno {


    private List<Aluno> alunos;

    public GerenciadorCadastroAluno() {
        this.alunos = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }


    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }




    public void listarAlunos() {
        if (alunos.size() == 0) {
            System.out.println("Esse aluno não existe");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(alunos);
            }
        }
    }

    public int quantidadeAlunos() {
        return alunos.size();
    }

    public void listarAlunosPorDisciplina(String nomeDisciplina) {
        for (Aluno aluno : alunos) {
            System.out.println("- " + aluno.getNome());
        }
    }


    public void listarAlunosPorProfessor(String nomeProfessor) {
        for (Aluno aluno : alunos) {
            System.out.println("- " + aluno.getNome());
        }
    }


    public Aluno[] getAlunos() {
        return new Aluno[0];
    }

}

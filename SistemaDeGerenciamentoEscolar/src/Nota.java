import java.util.ArrayList;
import java.util.List;

public class Nota {
    private double valor;
    private String data;
    private Aluno aluno;
    private Disciplina disciplina;

    List<Aluno> alunos = new ArrayList<>();
    List<Disciplina> disciplinas = new ArrayList<>();

    // Construtor
    public Nota(double valor, String data, Aluno aluno, Disciplina disciplina) {


        //Validação
        GerenciadorCadastroAluno gerenciadorAluno = null;
        if (gerenciadorAluno.buscarAluno(aluno.getNome()) == null) {
            throw new IllegalArgumentException("Aluno não cadastrado!");
        }
        GerenciadorCadastroDisciplina gerenciadorDisciplina = null;
        if (gerenciadorDisciplina.buscarDisciplina(disciplina.getNome()) == null) {
            throw new IllegalArgumentException("Disciplina não cadastrada!");
        }

        this.valor = valor;
        this.data = data;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    // Getters e Setters
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }



    @Override
    public String toString() {
        return "Nota: " + valor +
                ", Data: " + data +
                ", Aluno: " + aluno.getNome() +
                ", Disciplina: " + disciplina.getNome();
    }


}
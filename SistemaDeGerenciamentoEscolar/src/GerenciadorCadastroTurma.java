import java.util.ArrayList;
import java.util.List;

public class GerenciadorCadastroTurma {

    private List<Turma>turmas;

    public GerenciadorCadastroTurma(){
        this.turmas = new ArrayList<>();
    }




    public void cadastrarTurma(Turma turma) {
        if (turma.getProfessor() == null) {
            System.out.println("Erro: A turma deve estar associada a um professor.");
            return;
        }
        if (turma.getDisciplina() == null) {
            System.out.println("Erro: A turma deve estar associada a uma disciplina.");
            return;
        }
        turmas.add(turma);
        System.out.println("Turma cadastrada com sucesso!");

    }


        public void listarTurmas(){
        if(turmas.size() == 0 ){
            System.out.println("Esse turma não existe");
        }else {
            for (Turma turma : turmas) {
                System.out.println(turmas);
            }
        }
        }



}

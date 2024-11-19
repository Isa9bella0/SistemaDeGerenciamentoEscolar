import java.util.ArrayList;
import java.util.List;

public class GerenciadorCadastroProfessor {

    private List<Professor> professors;

    public GerenciadorCadastroProfessor() {
        this.professors = new ArrayList<>();
    }

    public void cadastrarProfessor (Professor professor){
    }



    public Professor buscarProfessor(String nome) {
        for (Professor professor : professors) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }

    public void listarProfessors(){
        if(professors.size() == 0 ) {
            System.out.println("Esse professor(a) não existe");
        }else{
                for(Professor profesor : professors){
                    System.out.println(professors);

                }

        }
    }
}



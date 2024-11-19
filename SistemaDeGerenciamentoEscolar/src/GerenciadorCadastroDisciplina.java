import java.util.ArrayList;
import java.util.List;

public class GerenciadorCadastroDisciplina {


   private List<Disciplina>disciplinas;

   public GerenciadorCadastroDisciplina() {
       this.disciplinas = new ArrayList<>();
   }



    public void cadastrarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }


    public Disciplina buscarDisciplina(String nome) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nome)) {
                return disciplina;
            }
        }
        return null;
    }


    public void listarDisciplinas() {
        if (disciplinas.size() == 0) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            for (Disciplina disciplina : disciplinas) {
                System.out.println(disciplina.getNome());
            }
        }

    }
}

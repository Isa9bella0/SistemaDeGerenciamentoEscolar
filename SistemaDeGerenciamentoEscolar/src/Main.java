import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    static Scanner scanner = new Scanner(System.in);

    private static GerenciadorCadastroAluno gerenciadorCadastroAluno = new GerenciadorCadastroAluno();
    private static GerenciadorCadastroDisciplina gerenciadorCadastroDisciplina = new GerenciadorCadastroDisciplina();
    private static GerenciadorCadastroProfessor gerenciadorCadastroProfessor = new GerenciadorCadastroProfessor();
    private static GerenciadorCadastroTurma gerenciadorCadastroTurma = new GerenciadorCadastroTurma();

    private static ArrayList<Nota> notas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int opcao;

        do {
            menu();
            opcao = Integer.parseInt(scanner.nextLine());
            if (opcao == 1) {
                cadastrarAluno();
            } else if (opcao == 2) {
                cadastrarProfessor();
            } else if (opcao == 3) {
                cadastrarDisciplina();
            } else if (opcao == 4) {
                cadastrarTurma();
            } else if (opcao == 5) {
                adicionarNota();
            } else if (opcao == 6) {
                listaAlunos();
            } else if (opcao == 7) {
                listarProfessores();
            } else if (opcao == 8) {
                listarDisciplina();
            } else if (opcao == 9) {
                listarTurmas();
            } else if (opcao == 10) {
                relatorioAlunoXNotaXMedia();
            } else if (opcao == 11) {
                quantidadeAluno();
            } else if (opcao == 12) {
                alunoMaiorNota();
            } else if (opcao == 13) {
                listarAlunosDeDisciplina();
            } else if (opcao == 14) {
                listarAlunosPorProfessor();
            } else if (opcao == 15) {
                sair();
            } else {
                System.out.println("Opção invalida!");
            }


        } while (opcao != 15);

    }


    // case 1
    private static void cadastrarAluno() {

        System.out.println("*");

        System.out.println("----------  CADASTRO ALUNO  ----------");
        System.out.println("*\n");

        System.out.println("Nome:");
        String nome = scanner.nextLine();

        System.out.println("Data de nascimento");
        String dataNascimento = scanner.nextLine();

        System.out.println("Telefone");
        String telefone = scanner.nextLine();

        System.out.println("Endereço");
        String endereco = scanner.nextLine();

        System.out.println("Matricula");
        String matricula = scanner.nextLine();

        System.out.println("Ano de ingresso");
        String anoIngresso = scanner.nextLine();

        Aluno aluno = new Aluno(nome, dataNascimento, telefone, endereco, matricula, anoIngresso);
        gerenciadorCadastroAluno.cadastrarAluno(aluno);

    }


    // case 2
    private static void cadastrarProfessor() {
        System.out.println("*");

        System.out.println("----------  CADASTRO PROFESSOR  ----------");
        System.out.println("*\n");

        System.out.println("Nome:");
        String nome = scanner.nextLine();

        System.out.println("Data de nascimento");
        String dataNascimento = scanner.nextLine();

        System.out.println("Area de Formação");
        String areaDeFormacao = scanner.nextLine();

        System.out.println("Ano De Admissao");
        String anoDeAdmissao = scanner.nextLine();

        System.out.println("telefone");
        String tefone = scanner.nextLine();

        System.out.println("e-mail");
        String email = scanner.nextLine();

        Professor professor = new Professor(nome, dataNascimento, anoDeAdmissao, tefone, email );
        gerenciadorCadastroProfessor.cadastrarProfessor(professor);

    }


    // case 3
    private static void cadastrarDisciplina() {

        System.out.println("*");

        System.out.println("----------  CADASTRO DISCIPLINA  ----------");
        System.out.println("*\n");

        System.out.println("Nome:");
        String nome = scanner.nextLine();

        System.out.println("Carga Horaria");
        String cargaHoraria = scanner.nextLine();

        System.out.println("Codigo");
        String codigo = scanner.nextLine();

        Disciplina disciplina = new Disciplina(nome, cargaHoraria, codigo );
        gerenciadorCadastroDisciplina.cadastrarDisciplina(disciplina);

    }

    // case 4
    private static void cadastrarTurma() {

        System.out.println("----------  CADASTRO DE NOVA TURMA  ----------");
        System.out.println("*\n");

        System.out.println("Escolha um professor: ");
        gerenciadorCadastroProfessor.listarProfessors();
        System.out.println("Nome do Professor(a):");
        String nomeProfessor = scanner.nextLine();
        Professor professor = gerenciadorCadastroProfessor.buscarProfessor(nomeProfessor);

        if (professor == null) {
            System.out.println("Professor não encontrada. Tente novamente.");
            return;
        }

        System.out.println("Escolha uma disciplina:");
        gerenciadorCadastroDisciplina.listarDisciplinas();
        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine();
        Disciplina disciplina = gerenciadorCadastroDisciplina.buscarDisciplina(nomeDisciplina);

        if (disciplina == null) {
            System.out.println("Professor não encontrada. Tente novamente.");
            return;
        }

        System.out.println("Ano Letivo:");
        int anoLetivo = Integer.parseInt(scanner.nextLine());

        System.out.println("Codigo:");
        int codigo = Integer.parseInt(scanner.nextLine());


        Turma turma = new Turma(codigo, disciplina, professor);
        gerenciadorCadastroTurma.cadastrarTurma(turma);
    }


    // case 5
    private static void adicionarNota() {
        System.out.println("*");

        System.out.println("----------  ADICIONANDO NOTA  ----------");
        System.out.println("*\n");

        System.out.println("Escolha uma disciplina:");
        gerenciadorCadastroDisciplina.listarDisciplinas();
        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine();
        Disciplina disciplina = gerenciadorCadastroDisciplina.buscarDisciplina(nomeDisciplina);

        if (disciplina == null) {
            System.out.println("Disciplina não encontrada. Tente novamente.");
            return;
        }

        System.out.println("Escolha um aluno:");
        gerenciadorCadastroAluno.listarAlunos();
        System.out.print("Nome do aluno: ");
        String nomeAluno = scanner.nextLine();
        Aluno aluno = gerenciadorCadastroAluno.buscarAluno(nomeAluno);

        if (aluno == null) {
            System.out.println("Aluno não encontrado. Tente novamente.");
            return;
        }

        System.out.print("Informe o valor da nota: ");
        double valorNota = Double.parseDouble(scanner.nextLine());

        System.out.print("Informe a data da nota: ");
        String dataNota = scanner.nextLine();

        Nota novaNota = new Nota(valorNota, dataNota, aluno, disciplina);
        notas.add(novaNota);
    }


    // case 6
    private static void listaAlunos() {
        System.out.println("*");

        System.out.println("---------- LISTA DE ALUNOS ----------");
        System.out.println("*\n");

        gerenciadorCadastroAluno.listarAlunos();

    }

    // case 7
    private static void listarProfessores() {
        System.out.println("*");

        System.out.println("---------- LISTA DE PROFESSORES ----------");
        System.out.println("*\n");

        gerenciadorCadastroProfessor.listarProfessors();
    }


    // case 8
    private static void listarDisciplina() {
        System.out.println("*");

        System.out.println("---------- LISTA DE DISCIPLINAS ----------");
        System.out.println("*\n");

        gerenciadorCadastroDisciplina.listarDisciplinas();
    }


    // case 9
    private static void listarTurmas() {
        System.out.println("*");

        System.out.println("---------- LISTA DE TURMAS ----------");
        System.out.println("*\n");

        gerenciadorCadastroTurma.listarTurmas();
    }


    // case 10
   private static void relatorioAlunoXNotaXMedia() {
       System.out.println("*");

      System.out.println("---------- RELATÓRIO ALUNO X NOTAS X MÉDIA ----------");
       System.out.println("*\n");

        for (Aluno aluno : gerenciadorCadastroAluno.getAlunos()) {
        System.out.println("Aluno: " + aluno.getNome());


       System.out.println("Notas:");
       double somaNotas = 0;
        int contadorNotas = 0;

      for (Nota nota : aluno.getNotas()) {
           System.out.println("- " + nota.getDisciplina().getNome() + ": " + nota.getValor() + " (Data: " + nota.getData() + ")");
          somaNotas += nota.getValor();
            contadorNotas++;
      }


        if (contadorNotas > 0) {
           double media = somaNotas / contadorNotas;
           System.out.println("Média: " + media);
        }
      }
   }




    // case 11
    private static void quantidadeAluno() {
        int quantidade = gerenciadorCadastroAluno.quantidadeAlunos();
        System.out.println("Quantidade de alunos cadastrados: " + quantidade);
    }

    // case 12
    private static void alunoMaiorNota() {
        System.out.println("*");
        System.out.println("---------- ALUNO COM MAIOR NOTA ----------");
        System.out.println("*\n");

        Aluno alunoComMaiorNota = null;
        double maiorNota = 0;


        for (Aluno aluno : gerenciadorCadastroAluno.getAlunos()) {

            for (Nota nota : aluno.getNotas()) {
                if (nota.getValor() > maiorNota) {
                    maiorNota = nota.getValor();
                    alunoComMaiorNota = aluno;
                }
            }
        }

        if (alunoComMaiorNota != null) {
            System.out.println("Aluno: " + alunoComMaiorNota.getNome());
            System.out.println("Maior Nota: " + maiorNota);
        }
    }


    // case 13
    private static void listarAlunosDeDisciplina() {
        System.out.println("*");
        System.out.println("----------  LISTAR ALUNOS POR DISCIPLINA  ----------");
        System.out.println("*\n");

        System.out.print("Digite o nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine();

        gerenciadorCadastroAluno.listarAlunosPorDisciplina(nomeDisciplina);
    }

    // case 14
    private static void listarAlunosPorProfessor() {
        System.out.println("*");
        System.out.println("----------  LISTAR ALUNOS POR PROFESSOR  ----------");
        System.out.println("*\n");

        System.out.print("Digite o nome o professor: ");
        String nomeProfessor = scanner.nextLine();

        gerenciadorCadastroAluno.listarAlunosPorProfessor(nomeProfessor);
    }

    // case 15
    private static void sair() {
        System.out.println("==============================================");
        System.out.println("===================  SAINDO...   ===================");
        System.out.println("==============================================");
    }


    private static void menu() {
        System.out.println("*******************************");
        System.out.println("*******************************");
        System.out.println("----------  MENU PRINCIPAL ----------");
        System.out.println("*******************************");
        System.out.println("*******************************\n");
        System.out.println("Escolha uma opção");
        System.out.println(" 1 - Cadastrar Aluno ");
        System.out.println(" 2 - Cadastrar Professor");
        System.out.println(" 3 - Cadastrar Disciplina");
        System.out.println(" 4 - Inserir Nota ");
        System.out.println(" 5 - Relatório Professores");
        System.out.println(" 6 - Relatório Alunos ");
        System.out.println(" 7 - Relatório Professor");
        System.out.println(" 8 - Relatório Disciplina");
        System.out.println(" 9 - Relatório Turmas ");
        System.out.println(" 10 - Relatório de Aluno x Notas x media");
        System.out.println(" 11 - Quantidade de alunos cadastrados ");
        System.out.println(" 12 - Nome do aluno que possui a maior nota");
        System.out.println(" 13 - Listar Alunos de uma determinada disciplina");
        System.out.println(" 14 - Listar turmas que estão associadas a um determinado Professor  ");
        System.out.println(" 15 - SAIR");
        System.out.println("\n Escolha uma opção");
    }
}





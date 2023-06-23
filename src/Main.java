import java.util.Scanner;

public class Main {
    private static final int MAX_TIMES = 15;
    private static final int MAX_AVALIADORES = 5;
    private static final int MAX_ALUNOS = 6;

    public static void main(String[] args) {
        Time[] times = new Time[MAX_TIMES];
        Avaliador[] avaliadores = new Avaliador[MAX_AVALIADORES];

        Scanner scanner = new Scanner(System.in);

        // Criação dos times
        int numeroTimes = criarTimes(scanner, times);

        // Criação dos avaliadores
        criarAvaliadores(scanner, avaliadores);

        // Avaliação dos times pelos avaliadores
        avaliarTimes(scanner, times, avaliadores);

        // Consultas
        Time timeVencedor = getTimeVencedor(times);
        if (timeVencedor != null) {
            System.out.println("Time vencedor: " + timeVencedor.getNome());
        } else {
            System.out.println("Não há times para avaliar.");
        }

        listarAlunos(times);
        listarTimesAcimaDe20(times);

        // Consulta de um time específico
        System.out.print("Digite o nome do time que deseja consultar: ");
        String nomeTime = scanner.nextLine();
        Time timeEspecifico = buscarTimePorNome(times, numeroTimes,nomeTime);
        if (timeEspecifico != null) {
            exibirInformacoesTime(timeEspecifico);
        } else {
            System.out.println("Time não encontrado.");
        }

        scanner.close();
    }

    private static int criarTimes(Scanner scanner, Time[] times) {
        int numeroTimes = MAX_TIMES;
        scanner.nextLine(); // Limpar o buffer do scanner

        for (int i = 0; i < numeroTimes; i++) {
            Time time = new Time();
            System.out.println("=== Criando time " + (i + 1) + " ===");
            System.out.print("Digite o nome do time: ");
            String nomeTime = scanner.nextLine();
            time.setNome(nomeTime);

            Aluno[] alunos = new Aluno[MAX_ALUNOS];
            for (int j = 0; j < MAX_ALUNOS; j++) {
                System.out.println("--- Aluno " + (j + 1) + " ---");
                System.out.print("Digite a matrícula do aluno: ");
                String matricula = scanner.nextLine();
                System.out.print("Digite o nome do aluno: ");
                String nomeAluno = scanner.nextLine();
                System.out.print("Digite o curso do aluno: ");
                String curso = scanner.nextLine();
                System.out.print("Digite o email do aluno: ");
                String email = scanner.nextLine();

                Aluno aluno = new Aluno(matricula, nomeAluno, curso, email);
                alunos[j] = aluno;
            }

            boolean sucesso = time.adicionaAlunos(alunos);
            if (sucesso) {
                times[i] = time;
                System.out.println("Time criado com sucesso.");
            } else {
                System.out.println("Erro ao criar time. Certifique-se de que há pelo menos 1 aluno de curso diferente.");
                i--; // Repetir a criação do time
            }
        }

        return numeroTimes;
    }

    private static void criarAvaliadores(Scanner scanner, Avaliador[] avaliadores) {

        int numeroAvaliadores = 5;
        scanner.nextLine(); // Limpar o buffer do scanner

        for (int i = 0; i < numeroAvaliadores; i++) {
            System.out.println("=== Criando avaliador " + (i + 1) + " ===");
            System.out.print("Digite o nome do avaliador: ");
            String nomeAvaliador = scanner.nextLine();

            Avaliador avaliador = new Avaliador(nomeAvaliador);
            avaliadores[i] = avaliador;
        }
    }

    private static void avaliarTimes(Scanner scanner, Time[] times, Avaliador[] avaliadores) {
        for (int i = 0; i < times.length; i++) {
            Time time = times[i];
            if (time != null) {
                System.out.println("=== Avaliando time " + time.getNome() + " ===");
                for (int j = 0; j < avaliadores.length; j++) {
                    Avaliador avaliador = avaliadores[j];
                    if (avaliador != null) {
                        System.out.print("Digite a nota dada pelo avaliador " + avaliador.getNome() + " (de 0 a 5): ");
                        double nota = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer do scanner

                        avaliador.avaliarTime(time, nota);
                    }
                }
            }
        }
    }


    private static Time getTimeVencedor(Time[] times) {
        double maiorNota = 0;
        Time timeVencedor = null;

        for (Time time : times) {
            if (time.mediaDeNotas() > maiorNota) {
                maiorNota = time.mediaDeNotas();
                timeVencedor = time;
            }
        }

        return timeVencedor;
    }

    private static void listarAlunos(Time[] times) {
        System.out.println("Alunos que participaram da hackatona: ");
        for (Time time : times) {
            time.listarAlunos();
        }
    }

    private static void listarTimesAcimaDe20(Time[] times) {
        System.out.println("Times com nota acima de 20: ");
        for (Time time : times) {
            if (time.mediaDeNotas() > 20) {
                System.out.println(time.getNome());
            }
        }
    }

    private static Time buscarTimePorNome(Time[] times, int numeroTimes, String nomeTime) {
        for (int i = 0; i < numeroTimes; i++) {
            Time time = times[i];
            if (time != null && time.getNome().equalsIgnoreCase(nomeTime)) {
                return time;
            }
        }
        return null;
    }

    private static void exibirInformacoesTime(Time time) {
        System.out.println("Nome do time: " + time.getNome());
        System.out.println("Alunos do time: ");
        time.listarAlunos();
        System.out.println("Notas do time: ");
        time.listarNotas();
    }
}
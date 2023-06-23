public class Main {
    public static void main(String[] args) {

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
}
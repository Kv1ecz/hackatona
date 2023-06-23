import java.util.Objects;
import java.util.Optional;

public class Time {
    private String nome;
    private Double []notas = new Double[5];
    private Aluno []alunos = new Aluno[6];

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double[] getNotas() {
        return notas;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public boolean adicionaNota(double nota) {
        int quantidadeNotas = 0;

        for(int i = 0; i<this.notas.length; i++){
            if(this.notas[i] != null){
                quantidadeNotas++;
            }
        }

        if(quantidadeNotas < 5){
            this.notas[quantidadeNotas] = nota;
            return true;
        }

        return false;
    }

    public boolean adicionaAlunos(Aluno[] alunos){
        if(verificaDiferentesCursos(alunos)){
            for (int i = 0; i< alunos.length; i++) {
                this.alunos[i] = alunos[i];
            }
            return true;
        }
        return false;
    }
    private boolean verificaDiferentesCursos(Aluno[] alunos){
        String curso = alunos[0].getCurso();
        for (Aluno aluno : alunos) {
            if (!Objects.equals(aluno.getCurso(), curso)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificaNotas(){
        return this.notas.length == 5;
    }

    public double mediaDeNotas(){
        double mediaNotas = 0;
        for (Double nota : this.notas) {
            mediaNotas+=nota;
        }
        return mediaNotas;
    }

    public void listarAlunos(){
        System.out.println("Estes são os alunos do time: ");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }

    public void listarNotas(){
        System.out.println("Estas são as notas do time: ");
        for (Double nota : notas) {
            System.out.println(nota);
        }
    }

}
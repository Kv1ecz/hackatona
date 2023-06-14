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
}

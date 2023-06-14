public class Avaliador {
    private String nome;

    public Avaliador(String nome) {
        this.nome = nome;
    }

    public void avaliarTime(Time time, Double nota){
        time.adicionaNota(nota);
    }
}

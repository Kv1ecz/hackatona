public class Aluno {
    private String matricula;
    private String nome;
    private String curso;
    private String email;

    public Aluno(String matricula, String nome, String curso, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

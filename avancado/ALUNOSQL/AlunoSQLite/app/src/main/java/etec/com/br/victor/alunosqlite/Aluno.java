package etec.com.br.victor.alunosqlite;

public class Aluno {

    private int id;
    private String nome;
    private String curso;
    private String cidade;
    private String cpf;
    private int idade;
    private int telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return  "Id: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Curso: " + curso + "\n" +
                "Cidade: " + cidade + "\n" +
                "Cpf: " + cpf + "\n" +
                "Idade: " + idade + "\n" +
                "Telefone: " + telefone;
    }
}

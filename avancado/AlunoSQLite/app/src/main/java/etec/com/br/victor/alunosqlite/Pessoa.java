package etec.com.br.victor.alunosqlite;

public class Pessoa {
    private String nome;
    private int idade;
    private String email;
    private String endereco;

    private int id;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    @Override
    public String toString() {
        return  "Nome: " + nome +
                "\nIdade: " + idade +
                "\nE-mail: " + email +
                "\nEndereco: " + endereco;
    }
}

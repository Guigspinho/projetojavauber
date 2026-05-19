/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/
public class Usuario {
    private String email;
    private String senha;
    private String nome;
    private String endereco;
    private String telefone;


    public Usuario(String email, String senha, String nome, String endereco, String telefone) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Usuario() {
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
    
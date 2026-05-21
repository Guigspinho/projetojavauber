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
    private int tipoConta; // 1 - Passageiro, 2 - Motorista


    public Usuario(String email, String senha, String nome, String endereco, String telefone, int tipoConta) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoConta = tipoConta;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getTipoConta() {
        return tipoConta;
    }
}
    
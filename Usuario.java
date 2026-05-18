/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/

import java.util.Scanner;

public class Usuario {
    private String email;
    private String senha;
    private String nome;
    private String endereço;
    private String telefone;
    
    public Funcionario(String email, String senha, String nome, String endereço, String telefone) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.endereço = endereço;
        this.telefone = telefone;
    }
    
    //Validação de entrada vazia com .isEmpty()
    Scanner entrada = new Scanner(System.in);
    public boolean cadastrarConta() {
        System.out.println("==== Faça o seu Cadastro ====");
        System.out.println("E-mail: ");
        do {
            email = entrada.nextLine();
            
            if (email.isEmpty()) {
                System.out.println("Entrada inválida! Tente novamente.");
            }
        } while (email.isEmpty());
        
        System.out.println("Senha: ");
        do {
            senha = entrada.nextLine();
            
            if (senha.isEmpty()) {
                System.out.println("Entrada inválida! Tente novamente.");
            }
        } while (senha.isEmpty());
        
        System.out.println("==== Cadastro Realizado com Sucesso ====");
    }
    
    
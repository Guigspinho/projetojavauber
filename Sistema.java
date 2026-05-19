/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/

import java.util.Scanner;
public class Sistema {
    Scanner entrada = new Scanner(System.in);
    int selecao_menu;
    private Usuario usuario;

    public Sistema() {
        usuario = new Usuario();
    }

    public void exibirMenuEntrada() {
        do {
            System.out.println("=== CarONE-M: Viagens compartilhadas ===");
            System.out.println("1. Cadastrar uma Conta");
            System.out.println("2. Fazer Login");
            System.out.println("3. Sair");
            System.out.println("========================================");
            System.out.print("Selecione uma opção: ");
            while (entrada.hasNextInt() == false) {
                System.out.println("Opção inválida. Digite um número de 1 a 3.");
                entrada.next();
            }
            selecao_menu = entrada.nextInt();
            entrada.nextLine();

            switch (selecao_menu) { // Escolher ação
                case 1:
                    cadastrarConta(entrada);
                    break;
                case 2:
                    logarConta(entrada);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }

        } while (selecao_menu != 3);
    }
    

    public boolean cadastrarConta(Scanner entrada) {
        System.out.println("\n==== Faça o seu Cadastro ====");

        System.out.print("Nome: ");
        usuario.setNome(validarCampo(entrada.nextLine()));

        System.out.print("Endereço: ");
        usuario.setEndereco(validarCampo(entrada.nextLine()));

        System.out.print("Telefone: ");
        usuario.setTelefone(validarCampo(entrada.nextLine()));

        System.out.print("E-mail: ");
        usuario.setEmail(validarCampo(entrada.nextLine()));
        
        System.out.print("Senha: ");
        usuario.setSenha(validarCampo(entrada.nextLine()));
        
        System.out.println("\n==== Cadastro Realizado com Sucesso ====\n");

        return true;
    }

    public boolean logarConta(Scanner entrada) {
        System.out.println("\n==== Faça o seu Login ====");
        System.out.print("E-mail: ");
        String email = entrada.nextLine();
        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        if (this.usuario.getEmail().equals(email) && this.usuario.getSenha().equals(senha)) {
            System.out.println("==== Login Realizado com Sucesso ====\n");
            return true;
        } else {
            System.out.println("\nEmail ou senha incorretos. Tente novamente.\n");
            return false;
        }
    }

    public String validarCampo(String campo) {
        while (campo.isEmpty()) {
            System.out.println("Entrada inválida! Tente novamente.");
            campo = entrada.nextLine();
        }
        return campo;
    }
}

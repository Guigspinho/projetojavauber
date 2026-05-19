/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {
    Scanner entrada = new Scanner(System.in);
    int selecao_menu;
    private ArrayList<Usuario> usuarios;

    public Sistema() {
        usuarios = new ArrayList<>();
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
        String nome = validarCampo(entrada.nextLine());

        System.out.print("Endereço: ");
        String endereco = validarCampo(entrada.nextLine());

        System.out.print("Telefone: ");
        String telefone = validarCampo(entrada.nextLine());

        System.out.print("E-mail: ");
        String email = validarCampo(entrada.nextLine());
        
        System.out.print("Senha: ");
        String senha = validarCampo(entrada.nextLine());

        Usuario usuario = new Usuario(email, senha, nome, endereco, telefone);
        usuarios.add(usuario);
        
        System.out.println("\n==== Cadastro Realizado com Sucesso ====\n");

        return true;
    }

    public boolean logarConta(Scanner entrada) {
        System.out.println("\n==== Faça o seu Login ====");
        System.out.print("E-mail: ");
        String email = entrada.nextLine();
        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                System.out.println("==== Login Realizado com Sucesso ====\n");
                return true;
            }
        }

        System.out.println("\nEmail ou senha incorretos. Tente novamente.\n");
        return false;
    }

    public String validarCampo(String campo) {
        while (campo.isEmpty()) {
            System.out.println("Entrada inválida! Tente novamente.");
            campo = entrada.nextLine();
        }
        return campo;
    }

    // Método para adicionar usuários manualmente na lista do sistema para o banco de dados
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}

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
    private ArrayList<Usuario> usuarios;

    public Sistema() {
        usuarios = new ArrayList<>();
    }


    /// MENUS DE NAVEGAÇÃO  

    public void exibirMenuEntrada() {
        int selecao_menu;
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

            switch (selecao_menu) {
                case 1:
                    cadastrarConta(entrada);
                    break;
                case 2:
                    Usuario usuarioLogado = logarConta(entrada);
                    if (usuarioLogado != null) {
                        if (usuarioLogado.getTipoConta() ==1) {
                            exibirMenuPassageiro(entrada);
                        } else {
                            exibirMenuMotorista(entrada);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }

        } while (selecao_menu != 3);
    }
    
    public void exibirMenuPassageiro(Scanner entrada) {
        int selecao_menu;
        do {
            System.out.println("=== CarONE-M: Viagens compartilhadas (Passageiro) ===");
            System.out.println("1. Buscar Carona");
            System.out.println("2. Avaliar Viagens Anteriores");
            System.out.println("3. Sair");
            System.out.println("=====================================================");
            System.out.print("Selecione uma opção: ");
            while (entrada.hasNextInt() == false) {
                System.out.println("Opção inválida. Digite um número de 1 a 3.");
                entrada.next();
            }
            selecao_menu = entrada.nextInt();
            entrada.nextLine();

            switch (selecao_menu) {
                case 1:
                    buscarCarona(entrada);
                    break;
                case 2:
                    avaliarViagens(entrada);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }

        } while (selecao_menu != 3);
    }

    public void exibirMenuMotorista(Scanner entrada) {
        int selecao_menu;
        do {
            System.out.println("=== CarONE-M: Viagens compartilhadas (Motorista) ===");
            System.out.println("1. Cadastrar Viagem");
            System.out.println("2. Confirmar Carona");
            System.out.println("3. Lista de Avaliações dos Passageiros");
            System.out.println("4. Sair");
            System.out.println("=====================================================");
            System.out.print("Selecione uma opção: ");
            while (entrada.hasNextInt() == false) {
                System.out.println("Opção inválida. Digite um número de 1 a 4.");
                entrada.next();
            }
            selecao_menu = entrada.nextInt();
            entrada.nextLine();

            switch (selecao_menu) {
                case 1:
                    cadastrarViagem(entrada);
                    break;
                case 2:
                    confirmarCarona(entrada);
                    break;
                case 3:
                    listaAvaliacoes(entrada);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }

        } while (selecao_menu != 4);
    }


    /// CADASTRO E LOGIN

    public boolean cadastrarConta(Scanner entrada) {
        System.out.println("\n==== Faça o seu Cadastro ====");

        System.out.println("Selecione o tipo de conta (1 - Passageiro, 2 - Motorista):");
        int tipoConta = entrada.nextInt();
        entrada.nextLine();
        if (tipoConta != 1 && tipoConta != 2) {
            System.out.println("\nTipo de conta inválido. Tente novamente.\n");
            return false;
        }

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

        if (tipoConta == 1) {
            Usuario passageiro = new Passageiro(email, senha, nome, endereco, telefone, tipoConta);
            usuarios.add(passageiro);
        } else {
            Usuario motorista = new Motorista(email, senha, nome, endereco, telefone, tipoConta);
            usuarios.add(motorista);
        }
        
        System.out.println("\n==== Cadastro Realizado com Sucesso ====\n");

        return true;
    }

    public Usuario logarConta(Scanner entrada) {
        System.out.println("\n==== Faça o seu Login ====");
        System.out.print("E-mail: ");
        String email = entrada.nextLine();
        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                System.out.println("==== Login Realizado com Sucesso ====\n");
                return usuario;
            }
        }

        System.out.println("\nEmail ou senha incorretos. Tente novamente.\n");
        return null;
    }

    public String validarCampo(String campo) {
        while (campo.isEmpty()) {
            System.out.println("Entrada inválida! Tente novamente.");
            campo = entrada.nextLine();
        }
        return campo;
    }


    /// MÉTODOS DE PASSAGEIRO
    
    
    /// MÉTODOS DE MOTORISTA


    // Método para adicionar usuários manualmente na lista do sistema para o banco de dados
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }



    public void buscarCarona(Scanner entrada) {

    }

    public void avaliarViagens(Scanner entrada) {

    }

    public void cadastrarViagem(Scanner entrada) {

    }

    public void confirmarCarona(Scanner entrada) {

    }

    public void listaAvaliacoes(Scanner entrada) {

    }
}

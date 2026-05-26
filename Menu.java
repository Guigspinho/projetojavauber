import java.util.Scanner;

public class Menu {
    Scanner entrada = new Scanner(System.in);
    private GerenciadorUsuario gerUsuarios;
    private GerenciadorViagem gerViagens;

    public Menu(GerenciadorUsuario gerUsuarios, GerenciadorViagem gerViagens) {
         this.gerUsuarios = gerUsuarios;
         this.gerViagens = gerViagens;
    }
    
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
                    gerUsuarios.cadastrarConta(entrada);
                    break;
                case 2:
                    System.out.println("1 - Passageiro | 2 - Motorista");
                    int tipo = entrada.nextInt();
                    entrada.nextLine();
                    if (tipo == 1) {
                        Passageiro passageiroLogado = gerUsuarios.logarPassageiro(entrada);
                        if (passageiroLogado != null) {
                            exibirMenuPassageiro(entrada, passageiroLogado);
                        }
                    } else if (tipo == 2) {
                        Motorista motoristaLogado = gerUsuarios.logarMotorista(entrada);
                        if (motoristaLogado != null) {
                            exibirMenuMotorista(entrada, motoristaLogado);
                        }
                    } else {
                        System.out.println("Tipo de conta inválido. Tente novamente.\n");
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
    
    public void exibirMenuPassageiro(Scanner entrada, Passageiro passageiroLogado) {
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
                    gerViagens.buscarESelecionarCarona(passageiroLogado, entrada);
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

    public void exibirMenuMotorista(Scanner entrada, Motorista motoristaLogado) {
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
                    gerViagens.registrarViagem(entrada, motoristaLogado);
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
    
}

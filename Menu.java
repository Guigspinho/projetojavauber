/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/
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
        int selecaoMenu;

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
            selecaoMenu = entrada.nextInt();
            entrada.nextLine();

            switch (selecaoMenu) {

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
                        System.out.println(
                                "Tipo de conta inválido. Tente novamente.\n"
                        );
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }

        } while (selecaoMenu != 3);
    }



    public void exibirMenuPassageiro(Scanner entrada, Passageiro passageiroLogado) {
        int selecaoMenu;
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
            selecaoMenu = entrada.nextInt();
            entrada.nextLine();

            switch (selecaoMenu) {
                case 1:
                    gerViagens.selecionarCarona(passageiroLogado,entrada);
                    break;

                case 2:
                    passageiroLogado.avaliarViagens(entrada, gerViagens.getViagens());
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }
        } while (selecaoMenu != 3);
    }

    public void exibirMenuMotorista(Scanner entrada, Motorista motoristaLogado) {
        int selecaoMenu;
        do {
            System.out.println("=== CarONE-M: Viagens compartilhadas (Motorista) ===");
            System.out.println("1. Cadastrar Viagem");
            System.out.println("2. Confirmar Carona");
            System.out.println("3. Ver Minha Média de Avaliações");
            System.out.println("4. Lista de Avaliações dos Passageiros");
            System.out.println("5. Sair");
            System.out.println("=====================================================");
            System.out.print("Selecione uma opção: ");
            while (entrada.hasNextInt() == false) {
                System.out.println("Opção inválida. Digite um número de 1 a 5.");
                entrada.next();
            }
            selecaoMenu = entrada.nextInt();
            entrada.nextLine();

            switch (selecaoMenu) {
                case 1:
                    gerViagens.registrarViagem(entrada,motoristaLogado);
                    break;

                case 2:
                    motoristaLogado.confirmarCarona(entrada);
                    break;
                
                case 3:
                    double media = gerUsuarios.calcularMediaAvaliacoes(motoristaLogado);
                    System.out.println("\n=== Sua Média de Avaliações ===");
                    System.out.printf("Média: %.2f\n\n", media);
                    break;

                case 4:
                    gerViagens.listarAvaliacoes(entrada);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }

        } while (selecaoMenu != 5);
    }
}

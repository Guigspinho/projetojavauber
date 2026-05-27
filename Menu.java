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

                        Passageiro passageiroLogado =
                                gerUsuarios.logarPassageiro(entrada);

                        if (passageiroLogado != null) {

                            exibirMenuPassageiro(entrada, passageiroLogado);
                        }

                    } else if (tipo == 2) {

                        Motorista motoristaLogado =
                                gerUsuarios.logarMotorista(entrada);

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

        } while (selecao_menu != 3);
    }

    public void exibirMenuPassageiro(
            Scanner entrada,
            Passageiro passageiroLogado
    ) {

        int selecao_menu;

        do {

            System.out.println(
                    "=== CarONE-M: Viagens compartilhadas (Passageiro) ==="
            );

            System.out.println("1. Buscar Carona");
            System.out.println("2. Avaliar Viagens Anteriores");
            System.out.println("3. Sair");

            System.out.println(
                    "====================================================="
            );

            System.out.print("Selecione uma opção: ");

            while (entrada.hasNextInt() == false) {

                System.out.println(
                        "Opção inválida. Digite um número de 1 a 3."
                );

                entrada.next();
            }

            selecao_menu = entrada.nextInt();
            entrada.nextLine();

            switch (selecao_menu) {

                case 1:

                    gerViagens.buscarESelecionarCarona(
                            passageiroLogado,
                            entrada
                    );

                    break;

                case 2:

                    avaliarViagens(entrada);
                    break;

                case 3:

                    System.out.println("Saindo...");
                    break;

                default:

                    System.out.println(
                            "Opção inválida. Tente novamente.\n"
                    );
            }

        } while (selecao_menu != 3);
    }

    public void exibirMenuMotorista(
            Scanner entrada,
            Motorista motoristaLogado
    ) {

        int selecao_menu;

        do {

            System.out.println(
                    "=== CarONE-M: Viagens compartilhadas (Motorista) ==="
            );

            System.out.println("1. Cadastrar Viagem");
            System.out.println("2. Confirmar Carona");
            System.out.println("3. Lista de Avaliações dos Passageiros");
            System.out.println("4. Sair");

            System.out.println(
                    "====================================================="
            );

            System.out.print("Selecione uma opção: ");

            while (entrada.hasNextInt() == false) {

                System.out.println(
                        "Opção inválida. Digite um número de 1 a 4."
                );

                entrada.next();
            }

            selecao_menu = entrada.nextInt();
            entrada.nextLine();

            switch (selecao_menu) {

                case 1:

                    gerViagens.registrarViagem(
                            entrada,
                            motoristaLogado
                    );

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

                    System.out.println(
                            "Opção inválida. Tente novamente.\n"
                    );
            }

        } while (selecao_menu != 4);
    }

    public void avaliarViagens(Scanner entrada) {

        if (gerViagens.getViagens().isEmpty()) {

            System.out.println("\nNenhuma viagem cadastrada.\n");
            return;
        }

        System.out.println("\n=== Viagens Disponíveis ===");

        for (int i = 0; i < gerViagens.getViagens().size(); i++) {

            System.out.println(
                    (i + 1) + " - " +
                            gerViagens.getViagens().get(i).resumoViagem()
            );
        }

        System.out.print("\nEscolha uma viagem: ");
        int escolha = entrada.nextInt();
        entrada.nextLine();

        if (escolha < 1 || escolha > gerViagens.getViagens().size()) {

            System.out.println("Viagem inválida.");
            return;
        }

        System.out.print("Digite uma nota (1 a 5): ");
        int nota = entrada.nextInt();
        entrada.nextLine();

        while (nota < 1 || nota > 5) {

            System.out.println("Nota inválida.");
            nota = entrada.nextInt();
            entrada.nextLine();
        }

        System.out.print("Digite um comentário: ");
        String comentario = entrada.nextLine();

        Avaliacao avaliacao = new Avaliacao(nota, comentario);

        gerViagens.getViagens()
                .get(escolha - 1)
                .getAvaliacoes()
                .add(avaliacao);

        System.out.println("\nAvaliação cadastrada com sucesso!\n");
    }

    public void confirmarCarona(Scanner entrada) {

        if (gerViagens.getViagens().isEmpty()) {

            System.out.println("\nNenhuma viagem cadastrada.\n");
            return;
        }

        System.out.println("\n=== Viagens ===");

        for (int i = 0; i < gerViagens.getViagens().size(); i++) {

            System.out.println(
                    (i + 1) + " - " +
                            gerViagens.getViagens().get(i).resumoViagem()
            );
        }

        System.out.print("\nEscolha uma viagem: ");
        int escolha = entrada.nextInt();
        entrada.nextLine();

        if (escolha < 1 || escolha > gerViagens.getViagens().size()) {

            System.out.println("Viagem inválida.");
            return;
        }

        gerViagens.getViagens()
                .get(escolha - 1)
                .listarPassageiros();
    }

    public void listaAvaliacoes(Scanner entrada) {

        if (gerViagens.getViagens().isEmpty()) {

            System.out.println("\nNenhuma viagem cadastrada.\n");
            return;
        }

        System.out.println("\n=== Viagens ===");

        for (int i = 0; i < gerViagens.getViagens().size(); i++) {

            System.out.println(
                    (i + 1) + " - " +
                            gerViagens.getViagens().get(i).resumoViagem()
            );
        }

        System.out.print("\nEscolha uma viagem: ");
        int escolha = entrada.nextInt();
        entrada.nextLine();

        if (escolha < 1 || escolha > gerViagens.getViagens().size()) {

            System.out.println("Viagem inválida.");
            return;
        }

        if (gerViagens.getViagens()
                .get(escolha - 1)
                .getAvaliacoes()
                .isEmpty()) {

            System.out.println("\nNenhuma avaliação cadastrada.\n");
            return;
        }

        System.out.println("\n=== Avaliações ===");

        for (Avaliacao avaliacao :
                gerViagens.getViagens()
                        .get(escolha - 1)
                        .getAvaliacoes()) {

            System.out.println("Nota: " + avaliacao.getNota());
            System.out.println("Comentário: " + avaliacao.getComentario());
            System.out.println("----------------------");
        }
    }
}

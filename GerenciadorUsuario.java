import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorUsuario {

    private ArrayList<Motorista> motoristas;
    private ArrayList<Passageiro> passageiros;

    public GerenciadorUsuario() {
        motoristas = new ArrayList<>();
        passageiros = new ArrayList<>();
    }

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
        String nome = validarCampo(entrada.nextLine(), entrada);

        System.out.print("Endereço: ");
        String endereco = validarCampo(entrada.nextLine(), entrada);

        System.out.print("Telefone: ");
        String telefone = validarCampo(entrada.nextLine(), entrada);

        System.out.print("E-mail: ");
        String email = validarCampo(entrada.nextLine(), entrada);

        System.out.print("Senha: ");
        String senha = validarCampo(entrada.nextLine(), entrada);

        if (tipoConta == 1) {
            Passageiro passageiro = new Passageiro(email, senha, nome, endereco, telefone);
            passageiros.add(passageiro);
        } else {
            Motorista motorista = new Motorista(email, senha, nome, endereco, telefone);
            motoristas.add(motorista);
        }
        
        System.out.println("\n==== Cadastro Realizado com Sucesso ====\n");

        return true;
    }

    public Passageiro logarPassageiro(Scanner entrada) {

        System.out.println("\n==== Login Passageiro ====");

        System.out.print("E-mail: ");
        String email = entrada.nextLine();

        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        for (Passageiro passageiro : passageiros) {

            if (passageiro.getEmail().equals(email) && passageiro.getSenha().equals(senha)) {
                System.out.println("\nLogin realizado!\n");
                return passageiro;
            }
        }

        System.out.println("\nEmail ou senha incorretos.\n");
        return null;
    }

    public Motorista logarMotorista(Scanner entrada) {

        System.out.println("\n==== Login Motorista ====");

        System.out.print("E-mail: ");
        String email = entrada.nextLine();

        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        for (Motorista motorista : motoristas) {

            if (motorista.getEmail().equals(email) && motorista.getSenha().equals(senha)) {
                System.out.println("\nLogin realizado!\n");
                return motorista;
            }
        }

        System.out.println("\nEmail ou senha incorretos.\n");
        return null;
    }

    public String validarCampo(String campo, Scanner entrada) {
        while (campo.isEmpty()) {
            System.out.println("Entrada inválida! Tente novamente.");
            campo = entrada.nextLine();
        }
        return campo;
    }
}

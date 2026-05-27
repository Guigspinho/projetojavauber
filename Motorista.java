/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Motorista extends Usuario {

    private ArrayList<Viagem> viagensMotorista = new ArrayList<>();

    public Motorista(String email, String senha, String nome, String endereço, String telefone) {
        super(email, senha, nome, endereço, telefone);
        viagensMotorista = new ArrayList<>();
    }

    public Viagem cadastrarViagem(Scanner entrada, ArrayList<Local> locais) {
        System.out.println("==== Cadastro de Viagem ====\n");

        System.out.println("Quantas vagas estão disponíveis?");
        int vagas = entrada.nextInt();
        if (vagas <= 0) {
            System.out.println("Número de vagas inválido! A viagem não pode ser cadastrada.");
            return null;
        }

        ArrayList<Local> trajeto = new ArrayList<>();

        System.out.println("Ponto de Partida:\n");

        for (int i = 0; i < locais.size(); i++) {
            System.out.println((i + 1) + " - " + locais.get(i).getNome());
        }

        int escolhaPartida = entrada.nextInt();
        entrada.nextLine();
        Local partida = locais.get(escolhaPartida - 1);


        System.out.println("Ponto de Destino:\n");

        for (int i = 0; i < locais.size(); i++) {
            System.out.println((i + 1) + " - " + locais.get(i).getNome());
        }

        int escolhaDestino = entrada.nextInt();
        entrada.nextLine();
        Local destino = locais.get(escolhaDestino - 1);


        trajeto.add(partida);

        System.out.println("Por quantos pontos a viagem irá passar? (Descarte o ponto de partida e o ponto de destino)\n");
        int quantidade = entrada.nextInt();
        entrada.nextLine();

        for(int i = 0; i < quantidade; i++) {
            System.out.println("\nEscolha o ponto " + (i + 1) + " do trajeto:\n");
            for (int j = 0; j < locais.size(); j++) {
                System.out.println((j + 1) + " - " + locais.get(j).getNome());
            }
            int escolhaPonto = entrada.nextInt();
            entrada.nextLine();
            trajeto.add(locais.get(escolhaPonto - 1));
        }

        trajeto.add(destino);

        Viagem viagem = new Viagem(vagas, partida, destino, this, trajeto);
        viagensMotorista.add(viagem);
        System.out.println("\nViagem cadastrada!\n");
        return viagem;

    }
}

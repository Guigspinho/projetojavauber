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
    
    public Viagem cadastrarViagem(Scanner entrada) {
        System.out.println("==== Cadastro de Viagem ====\n");

        System.out.println("Quantas vagas estão disponíveis?");
        int vagas = entrada.nextInt();
        if (vagas <= 0) {
            System.out.println("Número de vagas inválido! A viagem não pode ser cadastrada.");
            return null;
        }

        ArrayList<Local> trajeto = new ArrayList<>();

        System.out.println("Ponto de Partida:\n");

        System.out.println("Digite X:");
        int xPartida = entrada.nextInt();

        System.out.println("Digite Y:");
        int yPartida = entrada.nextInt();

        Local partida = new Local(xPartida, yPartida);

        System.out.println("Ponto de Destino:\n");

        System.out.println("Digite X:");
        int xDestino = entrada.nextInt();

        System.out.println("Digite Y:");
        int yDestino = entrada.nextInt();

        Local destino = new Local(xDestino, yDestino);

        trajeto.add(partida);

        System.out.println("Por quantos pontos a viagem irá passar? (Descarte o ponto de partida e o ponto de destino)\n");
        int quantidade = entrada.nextInt();

        for(int i = 0; i < quantidade; i++) {

            System.out.println("Digite X:");
            int x = entrada.nextInt();

            System.out.println("Digite Y:");
            int y = entrada.nextInt();

            trajeto.add(new Local(x, y));
        }
        trajeto.add(destino);

        Viagem viagem = new Viagem(vagas, partida, destino, this, trajeto);
        viagensMotorista.add(viagem);
        System.out.println("Viagem cadastrada!");
        return viagem;

    }
}
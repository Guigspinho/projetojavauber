/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Passageiro extends Usuario {
    
    public Passageiro(String email, String senha, String nome, String endereço, String telefone, int tipoConta) {
        super(email, senha, nome, endereço, telefone, tipoConta);
    }
    
    public ArrayList<Viagem> buscarCarona(Scanner entrada, ArrayList<Viagem> viagens) {
        ArrayList<Viagem> viagensEncontradas = new ArrayList<>();
        System.out.println("Ponto de partida:");
        System.out.println("Digite X:");
        int pontoPartidaX = entrada.nextInt();
        System.out.println("Digite Y:");
        int pontoPartidaY = entrada.nextInt();
        Local partida = new Local(pontoPartidaX, pontoPartidaY);

        System.out.println("Ponto de destino:");
        System.out.println("Digite X:");
        int pontoDestinoX = entrada.nextInt();
        System.out.println("Digite Y:");
        int pontoDestinoY = entrada.nextInt();
        Local destino = new Local(pontoDestinoX, pontoDestinoY);

        for (Viagem viagem : viagens) {
            if (viagem.estaContido(partida) && viagem.estaContido(destino) && viagem.getVagasDisp() > 0) {
                viagensEncontradas.add(viagem);
            }
        }
        return viagensEncontradas;

    }
    
}
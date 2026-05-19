/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Passageiro extends Usuario {
    
    public Passageiro(String email, String senha, String nome, String endereço, String telefone) {
        super(email, senha, nome, endereço, telefone);
    }
    
    public ArrayList<Viagem> buscarCarona(Scanner entrada) {
        System.out.println("==== Solicitação de Viagem ====\n");
        System.out.println("Digite o ponto de partida:");
        System.out.println("Digite X:");
        int xPartida = entrada.nextInt();
        System.out.println("Digite Y:");
        int yPartida = entrada.nextInt();
        Local partida = new Local(xPartida, yPartida);

        System.out.println("Digite o ponto de destino:");
        System.out.println("Digite X:");
        int xDestino = entrada.nextInt();
        System.out.println("Digite Y:");
        int yDestino = entrada.nextInt();
        Local destino = new Local(xDestino, yDestino);
        return new ArrayList<>();
    }
    
}
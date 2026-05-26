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
    
    public ArrayList<Viagem> buscarCarona(Scanner entrada, ArrayList<Viagem> viagens, ArrayList<Local> locais) {
        ArrayList<Viagem> viagensEncontradas = new ArrayList<>();

        System.out.println("Ponto de partida:");
        for (int i = 0; i < locais.size(); i++) {
            System.out.println((i + 1) + " - " + locais.get(i).getNome());
        }
        
        int escolhaPartida = entrada.nextInt();
        entrada.nextLine();
        Local partida = locais.get(escolhaPartida - 1);


        System.out.println("Ponto de destino:");
        for (int i = 0; i < locais.size(); i++) {
            System.out.println((i + 1) + " - " + locais.get(i).getNome());
        }
        
        int escolhaDestino = entrada.nextInt();
        entrada.nextLine();
        Local destino = locais.get(escolhaDestino - 1);

        for (Viagem viagem : viagens) {
            if (viagem.estaContido(partida) && viagem.estaContido(destino) && viagem.getVagasDisp() > 0) {
                viagensEncontradas.add(viagem);
            }
        }
        return viagensEncontradas;

    }

    
    
}
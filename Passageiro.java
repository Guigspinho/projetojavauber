/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Passageiro extends Usuario {

    public Passageiro(String email, String senha, String nome, String endereco, String telefone) {
        super(email, senha, nome, endereco, telefone);
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
            if (viagem.estaContido(partida) && viagem.estaContido(destino) && viagem.getVagasDisp() > 0 && viagem.getConcluida() == false) {
                viagensEncontradas.add(viagem);
            }
        }
        return viagensEncontradas;

    }

    public void avaliarViagens(Scanner entrada, ArrayList<Viagem> viagens) {

        ArrayList<Viagem> viagensParticipadas = new ArrayList<>();

        for (Viagem viagem : viagens) {
            for (Passageiro passageiro : viagem.getPassageirosConfirmados()) {
                if (passageiro == this) {
                viagensParticipadas.add(viagem);
                }
            }
        }

        if (viagensParticipadas.isEmpty()) {
            System.out.println( "\nVocê não participou de nenhuma viagem.\n");
            return;
        }

        System.out.println("\n=== Suas Viagens ===");
        for (int i = 0; i < viagensParticipadas.size(); i++) {
        System.out.println((i + 1) + " - " + viagensParticipadas.get(i).resumoViagem());
        }

        System.out.println("\nEscolha uma viagem:");
        int escolha = entrada.nextInt();
        entrada.nextLine();

        if (escolha < 1 || escolha > viagensParticipadas.size()) {
            System.out.println("Viagem inválida.");
            return;
        }
        Viagem viagemSelecionada = viagensParticipadas.get(escolha - 1);
        if (viagemSelecionada.getConcluida() == false) {
            System.out.println("\nEssa viagem ainda não foi concluída.\n");
            return;
        }

        System.out.println("\nDigite uma nota (1 a 5):");
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
        viagemSelecionada.getAvaliacoes().add(avaliacao);

        System.out.println("\nAvaliação cadastrada com sucesso!\n");
    }



}

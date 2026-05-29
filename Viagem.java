/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/

import java.util.ArrayList;

public class Viagem {

    private int vagasDisp;
    private Local partida;
    private Local destino;
    private ArrayList<Local> trajeto;
    private Motorista motorista;
    private ArrayList<Passageiro> passageirosPendentes;
    private ArrayList<Passageiro> passageirosConfirmados;
    private ArrayList<Avaliacao> avaliacoes;
    private boolean concluida;

    public Viagem(int vagasDisp, Local partida, Local destino, Motorista motorista, ArrayList<Local> trajeto) {
        this.vagasDisp = vagasDisp;
        this.partida = partida;
        this.destino = destino;
        this.motorista = motorista;
        this.trajeto = trajeto;
        passageirosPendentes = new ArrayList<>();
        passageirosConfirmados = new ArrayList<>();
        avaliacoes = new ArrayList<>();
        concluida = false;
    }

    public boolean estaContido(Local local) {
        double raio = 2.0;

        for(Local ponto : trajeto) {
            if(ponto.distancia(local) <= raio) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public String resumoViagem() {
        return
                "Motorista: " + motorista.getNome() +  "\n" +
                        "Partida: " + partida.getNome() + "\n" +
                        "Destino: " + destino.getNome() + "\n" +
                        "Vagas Disponíveis: " + vagasDisp;
    }


    public void solicitarCarona(Passageiro passageiro) {
        if (passageiroJaEstaNaViagem(passageiro)) {
            System.out.println("\nVocê já solicitou ou já faz parte desta viagem.\n");
            return;
        }
        passageirosPendentes.add(passageiro);
        System.out.println("\nSolicitação enviada ao motorista!\n");
    }

    public void aceitarPassageiro(Passageiro passageiro) {
        if (vagasDisp <= 0) {
            System.out.println("\nNão há vagas disponíveis.\n");
            return;
        }
        passageirosPendentes.remove(passageiro);
        passageirosConfirmados.add(passageiro);
        vagasDisp--;
        System.out.println("\nPassageiro aceito com sucesso!\n");
    }

    public void rejeitarPassageiro(Passageiro passageiro) {
        passageirosPendentes.remove(passageiro);
        System.out.println("\nSolicitação rejeitada.\n");
    }

    private boolean passageiroJaEstaNaViagem(Passageiro passageiro) {
        for (Passageiro p : passageirosPendentes) {
            if (p == passageiro) { 
                return true; 
            }
        }
    
        for (Passageiro p : passageirosConfirmados) {
            if (p == passageiro) {
                return true; 
            }
        }
        return false; 
    }



    //Getters e Setters

    public Local getDestino() {
        return destino;
    }

    public Local getPartida() {
        return partida;
    }

    public int getVagasDisp() {
        return vagasDisp;
    }

    public ArrayList<Passageiro> getPassageirosPendentes() {
        return passageirosPendentes;
    }

    public ArrayList<Passageiro> getPassageirosConfirmados() {
        return passageirosConfirmados;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public boolean getConcluida() {
        return concluida;
    }
    
    public Motorista getMotorista() {
        return motorista;
    }
    


}



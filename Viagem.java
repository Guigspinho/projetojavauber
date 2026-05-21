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
    private ArrayList<Passageiro> passageiros;
    private ArrayList<Avaliacao> avaliacoes;
    
    public Viagem(int vagasDisp, Local partida, Local destino, Motorista motorista, ArrayList<Local> trajeto) {
        this.vagasDisp = vagasDisp;     
        this.partida = partida;
        this.destino = destino;
        this.motorista = motorista;
        this.trajeto = trajeto;
        passageiros = new ArrayList<>();
        avaliacoes = new ArrayList<>();
    }
	
	//ver com o professor se pode usar o .size para medir o tamanho do ArrayList (o length só funciona em array fixo)
    public void adicionaPassageiro(Passageiro passageiro) {
        if (passageiros.size() < vagasDisp) {
            passageiros.add(passageiro);
        }
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

    public Local getDestino() {
        return destino;
    }

    public Local getPartida() {
        return partida;
    }
}


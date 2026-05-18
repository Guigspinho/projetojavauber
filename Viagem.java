/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/

public class Viagem {
    
    private int vagasDisp;
    private double raio;
    private Local partida;
    private Local destino;
    private Local localatual;
    private ArrayList<Local> trajeto;
    private Motorista motorista;
    private ArrayList<Passageiro> passageiros;
    private ArrayList<Avaliacao> avaliacoes;
    
    public Viagem(int vagasDisp, Local partida, Local destino, Motorista motorista) {
        this.vagasDisp = vagasDisp;
        this.raio = raio;       
        this.partida = partida;
        this.destino = destino;
        this.motorista = motorista;
        trajeto = new ArrayList<>();
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
        double distancia = localatual.distancia(local);
        return distancia <= raio;
    }
    
    public
    
}


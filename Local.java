/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/

public class Local {
    private int x;
    private int y;
    
    //construtor vazio caso use entrada de informaçoes
    public Local() {
        this.x = 0;
        this.y = 0;
    }
    
    //construtor construtor com parâmetros para criar o objeto já com valores (e simular o banco de dados)
    public Local(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    //fórmula para calcular a distancia entre dois pontos
    public double distancia(Local localponto) {
        double soma = Math.pow(localponto.x - this.x, 2) + Math.pow(localponto.y - this.y, 2);
        return Math.sqrt(soma);
    }
    
    
    public int getX() { 
        return x; 
    }

    public void setX(int x) {
        this.x = x; 
    }

    public int getY() { 
        return y;
    }

    public void setY(int y) {
        this.y = y; 
    }
}
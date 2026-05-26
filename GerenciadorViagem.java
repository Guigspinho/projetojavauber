import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorViagem {
    private ArrayList<Viagem> viagens;

    public GerenciadorViagem() {
        viagens = new ArrayList<>();
    }

    public void registrarViagem(Scanner entrada, Motorista motorista) {
        Viagem viagem = motorista.cadastrarViagem(entrada);
        if (viagem != null) {
            viagens.add(viagem);
        }
    }

    public void buscarESelecionarCarona(Passageiro passageiro, Scanner entrada) {
        ArrayList<Viagem> viagensEncontradas = passageiro.buscarCarona(entrada, viagens);
        if (viagensEncontradas.isEmpty()) {
            System.out.println("Nenhuma viagem encontrada.");
            return;
        } else {
            System.out.println("Viagens encontradas:");
            for (int i = 0; i < viagensEncontradas.size(); i++) {
                System.out.println((i + 1) + " - " + viagensEncontradas.get(i).resumoViagem());
            }
            System.out.println("Escolha uma viagem (0 para voltar): ");
            int escolha = entrada.nextInt();
            entrada.nextLine();
            if (escolha > 0 && escolha <= viagensEncontradas.size()) {
                Viagem caronaSelecionada = viagensEncontradas.get(escolha - 1);
                System.out.println("Carona confirmada para a viagem: " + caronaSelecionada.resumoViagem());
            }
        }
    }

    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

}

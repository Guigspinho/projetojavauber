/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorViagem {
    private ArrayList<Viagem> viagens;
    private ArrayList<Local> locais;

    public GerenciadorViagem() {
        viagens = new ArrayList<>();
        locais = new ArrayList<>();

        // Simulando um banco de dados de locais
        locais.add(new Local("Higienópolis", 0, 0));
        locais.add(new Local("República", 1, 2));
        locais.add(new Local("Paulista", 3, 3));
        locais.add(new Local("Paraíso", 5, 4));
        locais.add(new Local("Vila Mariana", 6, 4));

    }

    public void registrarViagem(Scanner entrada, Motorista motorista) {
        Viagem viagem = motorista.cadastrarViagem(entrada, locais);
        if (viagem != null) {
            viagens.add(viagem);
        }
    }

    public void selecionarCarona(Passageiro passageiro, Scanner entrada) {
        ArrayList<Viagem> viagensEncontradas = passageiro.buscarCarona(entrada, viagens, locais);
        if (viagensEncontradas.isEmpty()) {
            System.out.println("Nenhuma viagem encontrada.");
            return;
        } else {
            System.out.println("Viagens encontradas:");
            for (int i = 0; i < viagensEncontradas.size(); i++) {
                System.out.println("\n----------------------------------\n" + (i + 1) + " - " + viagensEncontradas.get(i).resumoViagem() + "\n----------------------------------");
            }
            System.out.println("Escolha uma viagem (0 para voltar): ");
            int escolha = entrada.nextInt();
            entrada.nextLine();
            if (escolha > 0 && escolha <= viagensEncontradas.size()) {
                Viagem caronaSelecionada = viagensEncontradas.get(escolha - 1);
                System.out.println("\nCarona confirmada para a viagem:\n" + caronaSelecionada.resumoViagem());
                caronaSelecionada.solicitarCarona(passageiro);
            }
        }
    }


    public void listarAvaliacoes(Scanner entrada) {

        if (viagens.isEmpty()) {
            System.out.println("\nNenhuma viagem cadastrada.\n");
            return;
        }

        System.out.println("\n=== Viagens ===");
        for (int i = 0; i < viagens.size(); i++) {

            System.out.println((i + 1) + " - " + viagens.get(i).resumoViagem());
        }
        System.out.print("\nEscolha uma viagem: ");
        int escolha = entrada.nextInt();
        entrada.nextLine();

        if (escolha < 1 || escolha > viagens.size()) {
            System.out.println("Viagem inválida.");
            return;
        }

        if (viagens.get(escolha - 1).getAvaliacoes().isEmpty()) {
            System.out.println("\nNenhuma avaliação cadastrada.\n");
            return;
        }

        System.out.println("\n=== Avaliações ===");

        for (Avaliacao avaliacao : viagens.get(escolha - 1).getAvaliacoes()) {
            System.out.println("Nota: " + avaliacao.getNota());
            System.out.println("Comentário: " + avaliacao.getComentario());
            System.out.println("----------------------");
        }
    }

    
    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

    public ArrayList<Local> getLocais() {
        return locais;
    }

}

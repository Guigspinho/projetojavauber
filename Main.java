/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		GerenciadorUsuario gerUsuarios = new GerenciadorUsuario();
		GerenciadorViagem gerViagens = new GerenciadorViagem();

		Menu menu = new Menu(gerUsuarios, gerViagens);
		menu.exibirMenuEntrada();


		entrada.close();


		Motorista m1 = new Motorista("joao@email.com", "123", "João", "Rua A", "1111");
        Passageiro p1 = new Passageiro("maria@email.com", "456", "Maria", "Rua B", "2222");

	}
}

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
		Usuario usuario = new Usuario();
		usuario.cadastrarConta(entrada);
		usuario.logarConta(entrada);

		entrada.close();
	}
}

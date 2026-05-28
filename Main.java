/*
Participantes
Nome: Guilherme Gomes Pinho - RA: 10755529
Nome: Lukas Barone Sussa - RA: 10753291
Nome: Ryan Silva de Sousa - RA: 10757255
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        GerenciadorUsuario gerUsuarios = new GerenciadorUsuario();
        GerenciadorViagem gerViagens = new GerenciadorViagem();
        
        //Banco de Dados
        Motorista m1 = new Motorista(
                    "joao@email.com",
                    "123",
                    "João",
                    "Rua A",
                    "1111"
        );
        Motorista m2 = new Motorista(
                    "carlos@email.com",
                    "123",
                    "Carlos",
                    "Rua B",
                    "2222"
        );
        Passageiro p1 = new Passageiro(
                    "maria@email.com",
                    "123",
                    "Maria",
                    "Rua C",
                    "3333"
        );
        Passageiro p2 = new Passageiro(
                    "ana@email.com",
                    "123",
                    "Ana",
                    "Rua D",
                    "4444"
        );

        gerUsuarios.getMotoristas().add(m1);
        gerUsuarios.getMotoristas().add(m2);

        gerUsuarios.getPassageiros().add(p1);
        gerUsuarios.getPassageiros().add(p2);

        ArrayList<Local> trajeto1 = new ArrayList<>();
        Local higienopolis = gerViagens.getLocais().get(0);
        Local republica = gerViagens.getLocais().get(1);
        Local paulista = gerViagens.getLocais().get(2);
        Local paraiso = gerViagens.getLocais().get(3);
        Local vilaMariana = gerViagens.getLocais().get(4);

        trajeto1.add(higienopolis);
        trajeto1.add(republica);
        trajeto1.add(paulista);
        trajeto1.add(paraiso);
        trajeto1.add(vilaMariana);

        Viagem v1 = new Viagem(
                                3,
                                higienopolis,
                                paulista,
                                m1,
                                trajeto1
        );

         m1.getViagensMotorista().add(v1);
         gerViagens.getViagens().add(v1);




        Menu menu = new Menu(gerUsuarios, gerViagens);
        menu.exibirMenuEntrada();


        entrada.close();



    }
}


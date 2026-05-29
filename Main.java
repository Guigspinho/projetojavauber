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
        Motorista m3 = new Motorista(
                "fernanda@email.com",
                "123",
                "Fernanda",
                "Rua C",
                "3333"
        );
        Motorista m4 = new Motorista(
                "ricardo@email.com",
                "123",
                "Ricardo",
                "Rua D",
                "4444"
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
        Passageiro p3 = new Passageiro(
                "lucas@email.com",
                "123",
                "Lucas",
                "Rua G",
                "7777"
        );

        Passageiro p4 = new Passageiro(
                "juliana@email.com",
                "123",
                "Juliana",
                "Rua H",
                "8888"
        );


        gerUsuarios.getMotoristas().add(m1);
        gerUsuarios.getMotoristas().add(m2);
        gerUsuarios.getMotoristas().add(m3);
        gerUsuarios.getMotoristas().add(m4);

        gerUsuarios.getPassageiros().add(p1);
        gerUsuarios.getPassageiros().add(p2);
        gerUsuarios.getPassageiros().add(p3);
        gerUsuarios.getPassageiros().add(p4);

        
        Local higienopolis = gerViagens.getLocais().get(0);
        Local republica = gerViagens.getLocais().get(1);
        Local paulista = gerViagens.getLocais().get(2);
        Local paraiso = gerViagens.getLocais().get(3);
        Local vilaMariana = gerViagens.getLocais().get(4);
        Local liberdade = gerViagens.getLocais().get(5);
        Local aclimacao = gerViagens.getLocais().get(6);
        Local santana = gerViagens.getLocais().get(7);

        ArrayList<Local> trajeto1 = new ArrayList<>();
        trajeto1.add(higienopolis);
        trajeto1.add(republica);
        trajeto1.add(paulista);
        trajeto1.add(paraiso);
        trajeto1.add(vilaMariana);

        ArrayList<Local> trajeto2 = new ArrayList<>();
        trajeto2.add(santana);
        trajeto2.add(republica);
        trajeto2.add(liberdade);
        trajeto2.add(aclimacao);

        ArrayList<Local> trajeto3 = new ArrayList<>();
        trajeto3.add(vilaMariana);
        trajeto3.add(paraiso);
        trajeto3.add(paulista);

        Viagem v1 = new Viagem(
                3,
                higienopolis,
                paulista,
                m1,
                trajeto1
        );
        Viagem v2 = new Viagem(
                2,
                santana,
                aclimacao,
                m2,
                trajeto2
        );
        Viagem v3 = new Viagem(
                4,
                vilaMariana,
                paulista,
                m3,
                trajeto3
        );

        v1.getPassageirosConfirmados().add(p1);
        v1.getPassageirosConfirmados().add(p2);
        v2.getPassageirosConfirmados().add(p3);
        v3.getPassageirosConfirmados().add(p4);

        v1.getPassageirosPendentes().add(p3);
        v2.getPassageirosPendentes().add(p1);

        v2.setConcluida(true);

        Avaliacao a1 = new Avaliacao(
                5,
                "Motorista muito educado e pontual."
        );
        Avaliacao a2 = new Avaliacao(
                4,
                "Viagem tranquila e confortável."
        );
        Avaliacao a3 = new Avaliacao(
                5,
                "Excelente experiência!"
        );

        v1.getAvaliacoes().add(a1);
        v1.getAvaliacoes().add(a2);
        v2.getAvaliacoes().add(a3);

        m1.getViagensMotorista().add(v1);
        m2.getViagensMotorista().add(v2);
        m3.getViagensMotorista().add(v3);

        gerViagens.getViagens().add(v1);
        gerViagens.getViagens().add(v2);
        gerViagens.getViagens().add(v3);


        //Início do Programa
        Menu menu = new Menu(gerUsuarios, gerViagens);
        menu.exibirMenuEntrada();


        entrada.close();



    }
}


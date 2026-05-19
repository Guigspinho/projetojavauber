import java.util.Scanner;
public class ValidadorSenha{

    public static boolean validarSenha(String senha) {

        //criação das variaveis
        boolean letraMinuscula;
        boolean letraMaiscula;
        boolean numero;
        boolean caracEspecial;

        //definicao das variaveis
        letraMinuscula = false;
        letraMaiscula = false;
        numero = false;
        caracEspecial = false;

        //validacao da quantidade de caracteres
        if (senha.length() < 8) {
            return false;
        }

        //processo de validacao de cada caracter inserido na senha
        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            if (c >= 'a' && c <= 'z') {
                letraMinuscula = true;
            } else if (c >= 'A' && c <= 'Z') {
                letraMaiscula = true;
            } else if (c >= '0' && c <= '9') {
                numero = true;
            } else {
                caracEspecial = true;
            }
        }
        return letraMinuscula && letraMaiscula && numero && caracEspecial;
    }

    public static void main(String[] args){
        Scanner validar = new Scanner(System.in);

        String senha;

        System.out.print("Digite sua senha: ");
        senha = validar.nextLine();

        if(validarSenha(senha)){
            System.out.println("Senha cadastrada!");
        } else{
            System.out.println("Senha incorreta!");
        }
    }
}

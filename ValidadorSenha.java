import java.util.Scanner;
public class ValidadorSenha{
    public static void main(String[] args){
        Scanner validar = new Scanner(System.in);

        //criação das variaveis
        String senha;
        boolean letraMinuscula;
        boolean letraMaiscula;
        boolean numero;
        boolean caracEspecial;

        //definicao das variaveis
        letraMinuscula = false;
        letraMaiscula = false;
        numero = false;
        caracEspecial = false;

        //entrada 
        System.out.print("Digite sua senha: ");
        senha = validar.nextLine();

        //condicional
        if (senha.length() < 8) {
            System.out.print("Senha inválida!");
           //else usado para poder fazer a verificação de caracteres da senha 
        } else {
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
        }

        //condiçao final usando o que seria um return de um método estático, avaliando cada variavel utilizada
        if(letraMinuscula && letraMaiscula && numero && caracEspecial){
            System.out.println("Senha cadastrada!");
        } else{
            System.out.println("Senha incorreta!");
        }
    }
}

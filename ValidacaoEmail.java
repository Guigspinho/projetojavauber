import java.util.Scanner;
public class ValidacaoEmail{
    public static void main(String[] args){
        Scanner gmail = new Scanner(System.in);

        String email;
        boolean arroba;
        int localArroba;

        System.out.print("Digite seu email: ");
        email = gmail.nextLine();
        arroba = false;
        localArroba = 0;

        for(int i = 0; i < email.length(); i++){

            char c = email.charAt(i);

            if(c == '@'){
                arroba = true;
                localArroba = i;
            }
        }

        if(arroba && localArroba < 7){
            System.out.println("Email validado com sucesso!");
        } else{
            System.out.println("Email incorreto!");
        }
        gmail.close();
    }
}

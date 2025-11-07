import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Encryptor encryptor = new Encryptor();

//        encryptor.encrypt(scanner);

        boolean check = false;
        do{
            System.out.println("Are we encrypting or decrypting? (e/d)");
            String input = scanner.nextLine();
            if(input.equals("e") ||  input.equals("d")){
                check = true;
                if(input.equals("e")){
                    Encryptor.encrypt(scanner);
                }
                else{
                    Encryptor.decrypt(scanner);
                }
            }
        }while(!check);
        scanner.close();
    }
}

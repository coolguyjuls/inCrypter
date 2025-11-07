import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

import java.io.IOException;

public class Encryptor {
//    String userInput = "";
    String keyInput = "";
    Key key;
    Scanner scanner;
    static final String characterList= "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!?@#$%^&*()_+|/,.;:-"+" ";
    static char[] characterArray = characterList.toCharArray();

    public static void encrypt(Scanner scanner) {
        
        System.out.println("Enter your message here: ");
        String userInput = scanner.nextLine();
        Message message = new Message(userInput);

        String randomFive ="";
        for (int i = 0; i < 5; i++){
            int randomInt = new Random().nextInt(10);
            StringBuilder stringBuilder = new StringBuilder(randomFive);
            stringBuilder.append(randomInt);
            randomFive = stringBuilder.toString();
            System.out.println("new number generated:" + randomInt);
        }

        message.setMessageId(randomFive);
        System.out.println("unique id: "+randomFive);
        Key key = new Key(randomFive);

//        creating new cipher string
        char[] cipherArray = characterArray.clone();
        System.out.println("shuffling...");
        int n = cipherArray.length;
        Random rand = new Random();

        System.out.println("Shuffling....");
        for (int i = n-1; i >= 1; i--){
            int j = rand.nextInt(i+1);
            char temp = cipherArray[i];
            cipherArray[i] = cipherArray[j];
            cipherArray[j] = temp;
        }
        System.out.println("Shuffled");

        String cipherArrayString = new String(cipherArray);
        System.out.println("cipher created: "+ cipherArrayString);
        String encryptedMessage = "";

//        encrypting message function
        for (int i = 0; i < userInput.length(); i++){
            char characterInMessage = userInput.charAt(i);
            System.out.println("character in message is: "+ characterInMessage);
//            String characterArrayString = Arrays.toString(characterArray);
            int indexOfCharacter = characterList.indexOf(characterInMessage);
            System.out.println("the index of "+ characterInMessage+" in the master array is "+ indexOfCharacter);
//            String cipherArrayString = Arrays.toString(cipherArray);
            char charInCipher = cipherArray[indexOfCharacter];
            System.out.println("the matching index in the cipher's string is "+  charInCipher);
            StringBuilder builder = new StringBuilder(encryptedMessage);
            builder.append(charInCipher);
            encryptedMessage = builder.toString();

            System.out.println("encrypted message generating....");
        }
        
        //setting cipher string to key, setting message to new encrypted message
        key.setKeyCipher(cipherArrayString);
        message.setMessage(encryptedMessage);
        System.out.println("encrypted message: " + message.getMessage());
        System.out.println(key.toString());
        
        createNewFile(randomFive,  encryptedMessage );
        System.out.println("messgae file created...");
        createNewFile(randomFive, cipherArrayString);
        System.out.println("key file created...");




    }


    public static void createNewFile(String fileName, String fileContent){
//        fileName = fileName + ".txt";
        try{
            String desktopDirectory = System.getProperty("user.home") + "/Desktop/";
            System.out.println(desktopDirectory);

            if (new File(desktopDirectory+fileName+"msg.txt").exists()){
                File file = new File(desktopDirectory + fileName+ "ky.txt");
                System.out.println("creating key file: " + file.toString()+"...");
//
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(fileContent);
                bw.close();

                System.out.println("key file created....");
                System.out.println("helloo");
            } else {
                File file = new File(desktopDirectory + fileName + "msg.txt");
                System.out.println("creating message file: " + file.toString()+"...");
//
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(fileContent);
                bw.close();

//            throw new RuntimeException(IOException);
                System.out.println("message file created....");
                System.out.println("helloo");
            }
        }
        catch (IOException e){
            System.out.println("An error occurred...");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("file created...bitch.");

    }
}

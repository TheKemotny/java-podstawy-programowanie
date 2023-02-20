package February20;

import java.io.Console;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class February20 {

    public static String caesarCipher(String message, int shift){
        StringBuilder stringBuilder = new StringBuilder();
        String plLetters = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ";
        String plLettersButLowerCase = plLetters.toLowerCase();
        for(String character: message.split("")) {
            if(plLetters.contains(character)) {
                int indexOfChar = plLetters.indexOf(character);
                indexOfChar += shift;
                indexOfChar %= plLetters.length();
                stringBuilder.append(plLetters.charAt(indexOfChar));
            } else if (plLettersButLowerCase.contains(character)) {
                int indexOfChar = plLettersButLowerCase.indexOf(character);
                indexOfChar += shift;
                indexOfChar %= plLettersButLowerCase.length();
                stringBuilder.append(plLettersButLowerCase.charAt(indexOfChar));
            } else if (Character.isDigit(character.charAt(0))) {
                int result = Integer.parseInt(character);
                result += shift;
                result %= 10;
                stringBuilder.append(String.valueOf(result));
            } else {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    public static String encryptMessage(String message){
        return caesarCipher(message, 3);
    }

    public static String decryptMessage(String message){
        return caesarCipher(message, -3);
    }

    public static String encryptMessage(String message, int shift){
        return caesarCipher(message, shift);
    }

    public static String decryptMessage(String message, int shift){
        return caesarCipher(message, shift * -1);
    }

    public static void printMenu(){
        System.out.println("1. ENCRYPT MESSAGE");
        System.out.println("2. DECRYPT MESSAGE");
        System.out.println("3. CHANGE SHIFT");
        System.out.println("0. EXIT");
    }

    public static void taskCaesar(){
        Scanner scanner = new Scanner(System.in);
        boolean isDone = false;
        int shift = 3;
        do {
            printMenu();
            int option = getNumberFromUserWithMessage("OPTION: ");
            switch (option){
                case 1 -> {
                    System.out.print("ENTER MESSAGE: ");
                    String message = scanner.nextLine();
                    System.out.println(encryptMessage(message, shift));
                }
                case 2 -> {
                    System.out.print("ENTER MESSAGE: ");
                    String message = scanner.nextLine();
                    System.out.println(decryptMessage(message, shift));
                }
                case 3 -> {
                    shift = getNumberFromUserWithMessage("ENTER NEW SHIFT: ");
                }
                case 0 -> {
                    isDone = true;
                }
                default -> {
                    System.out.println("NOT YET IMPLEMENTED");
                }
            }
        }while (!isDone);
    }

    public static int getNumberFromUserWithMessage(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String userInput = scanner.nextLine();
        int result;
        result = Integer.parseInt(userInput);
        return result;
    }

    public static void printArray(int[] array){
        for(int number : array){
            System.out.print(number + "\t");
        }
        System.out.println();
    }

    public static int[] getTenIntegersFromUser(){
        int[] arrayToReturn = new int[10];
        System.out.println("ENTER NUMBERS: ");
        for(int i = 0; i < arrayToReturn.length; i++) {
            arrayToReturn[i] = getNumberFromUserWithMessage(i + ":\t");
        }
        return arrayToReturn;
    }

    public static void taskOne(){
        int[] array = getTenIntegersFromUser();
        printArray(array);
        System.out.println("NUMBERS WITH MINIMUM 2 OCCURRENCES");
        A: for(int i = 0; i < (array.length - 1); i++){
            B: for(int j = (i + 1); j < array.length; j++){
                if(array[i] == array[j]) {
                    System.out.println(array[i]);
                    break;
                }
            }
        }
    }

    public static void taskTwo(){
        int[] array = getTenIntegersFromUser();
        printArray(array);
        int longestSequenceOfNumbers = 1;
        int currentLongestSequence = 1;
        int firstIndexOfSequence = 0;
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] < array[i+1]){
                currentLongestSequence++;
            }else{
                currentLongestSequence = 1;
                firstIndexOfSequence = i + 1;
            }
            longestSequenceOfNumbers = Math.max(longestSequenceOfNumbers, currentLongestSequence);
        }
        System.out.println(longestSequenceOfNumbers);
        for(int i = firstIndexOfSequence; i < (firstIndexOfSequence + currentLongestSequence); i++){
            System.out.print(array[i] + "\t");
        }
    }

    public static void main(String[] args) {
        //taskCaesar();
        taskTwo();
    }
}

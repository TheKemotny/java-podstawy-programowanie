package February20;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class February20 {

    public static int[] deleteDuplicateNumbers(int... numbers){
        Arrays.sort(numbers);
        int[] arrayToReturn = new int[1];
        arrayToReturn[0] = numbers[0];
        int counter = 0;
        for(int i = 0; i < numbers.length - 1; i++){
            if(numbers[i] != numbers[i + 1]) {
                arrayToReturn = Arrays.copyOf(arrayToReturn, arrayToReturn.length + 1);
                arrayToReturn[++counter] = numbers[i + 1];
            }
        }
        return arrayToReturn;
    }


    public static String caesarCipher(String message, int shift){
        StringBuilder stringBuilder = new StringBuilder();
        String plLetters = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ";
        for(String character: message.split("")) {
            int result = shift;
            result += plLetters.indexOf(character.toUpperCase());
            result %= plLetters.length();
            if (result < 0) result = result + plLetters.length();
            if(plLetters.contains(character)) {
                stringBuilder.append(plLetters.charAt(result));
            } else if (plLetters.toLowerCase().contains(character)) {
                stringBuilder.append(plLetters.toLowerCase().charAt(result));
            } else if (Character.isDigit(character.charAt(0))) {
                result = shift;
                result += Integer.parseInt(character);
                result %= 10;
                stringBuilder.append(result);
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
                case 3 -> shift = getNumberFromUserWithMessage("ENTER NEW SHIFT: ");
                case 0 -> isDone = true;
                default -> System.out.println("NOT YET IMPLEMENTED");
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
        for(int i = 0; i < (array.length - 1); i++){
            for(int j = (i + 1); j < array.length; j++){
                if(array[i] == array[j]) {
                    System.out.println(array[i]);
                    break;
                }
            }
        }
    }

    public static int findLongestSequenceInNumbers(int... numbers){
        int longestSequenceOfNumbers = 1;
        int currentLongestSequence = 1;
        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] < numbers[i+1]) {
                currentLongestSequence++;
            }else {
                currentLongestSequence = 1;
            }
            longestSequenceOfNumbers = Math.max(longestSequenceOfNumbers, currentLongestSequence);
        }
        return longestSequenceOfNumbers;
    }

    public static void taskTwo(){
        int[] array = getTenIntegersFromUser();
        printArray(array);
        int longestSequenceOfNumbers = findLongestSequenceInNumbers(array);
        System.out.println(longestSequenceOfNumbers);
    }

    public static String getInputFromUserWithMessage(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }

    public static long daysUntilDate(LocalDateTime date){
        Duration duration = Duration.between(LocalDateTime.now(), date);
        return duration.toDays();
    }

    public static void taskThree(){
        String userInput = getInputFromUserWithMessage("ENTER DATE (DD MM YEAR): ");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy HH mm ss");
        userInput = userInput.concat(" 17 30 00");
        LocalDateTime date = LocalDateTime.parse(userInput, dateTimeFormatter);
        long days = daysUntilDate(date);
        if(days < 0) {
            System.out.println("COURSE HAS ALREADY TAKEN PLACE");
        } else if (days == 0) {
            System.out.println("COURSE IS TODAY");
        } else {
            System.out.println("DAYS UNTIL NEXT COURSE: " + days);
        }
    }

    public static void main(String[] args) {
        taskCaesar();
        //taskTwo();
        //System.out.println(Arrays.toString(deleteDuplicateNumbers(20, 20, 30, 40, 50, 50, 50)));
        //taskThree();
    }
}

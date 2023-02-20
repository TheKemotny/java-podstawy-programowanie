package February16;

import java.util.Scanner;

public class February16 {

    public static int power(int number, int pow){
        if(pow == 0) return 1;

        int result = number;
        int temp = number;

        for (int i = 1; i < pow; i++) {
            for (int j = 1; j < number; j++) {
                result += temp;
            }
            temp = result;
        }

        return result;
    }

    public static String getUserInputUntilSafeWord(String safeWord){
        Scanner scanner = new Scanner(System.in);

        int inputCounter = 0;
        String result = "";

        System.out.println("ENTER WORDS IF YOU DONE USE SAFE WORD");
        do{
            System.out.print(inputCounter++ + ":\t");

            String input = scanner.nextLine();
            if (input.equals(safeWord)) break;
            if (input.length() > result.length() && !input.isBlank()) result = input;
        }while (true);

        if (result.isEmpty()) return "Nie podano żadnego tekstu";
        return result;
    }

    public static void taskOne(){
        String safeWord = "Starczy";
        System.out.println("LONGEST STRING: " + getUserInputUntilSafeWord(safeWord));
    }

    public static float percentageOfWhitespacesInString(String sentence){
        if (sentence.isEmpty()) return -1f;
        return ((sentence.length() - sentence.replaceAll(" ", "").length()) / (float) sentence.length()) * 100;
    }

    public static void taskTwo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ENTER SENTENCE: ");
        String input = scanner.nextLine();
        float percentage = percentageOfWhitespacesInString(input);
        if (percentage == -1f) System.out.println("SENTENCE IS BLANK");
        else System.out.println("PERCENTAGE OF WHITESPACE IN YOUR SENTENCE: " + percentage + "%");
    }

    public static String stammer(String sentence){
        StringBuilder stringBuilder = new StringBuilder();

        for(String word: sentence.split(" ")){
            stringBuilder.append(word).append(" ").append(word).append(" ");
        }

        return stringBuilder.toString();
    }

    public static void taskThree(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("SENTENCE: ");
        String sentence = scanner.nextLine();

        System.out.println(stammer(sentence));
    }

    public static void main(String[] args) {
        //taskOne();
        //System.out.println(power(5,4));
        taskTwo();
        taskThree();
        System.out.println();
    }
}

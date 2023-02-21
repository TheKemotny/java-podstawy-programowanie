package February21;

import February20.February20;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class February21 {
    public static void guessGame(int lowerRange, int upperRange) {
        int randomNumber = generateRandomNumber(lowerRange, upperRange);
        boolean isDone = false;
        int userGuess, counter = 1, lastLower = lowerRange, lastUpper = upperRange;
        do {
            String message = "ENTER " + (counter++) + " NUMBER: ";
            userGuess = February20.getNumberFromUserWithMessage(message);
            if(userGuess == randomNumber) {
                System.out.println("CONGRATULATIONS ! AFTER " + counter + " times.");
                isDone = true;
            } else if (userGuess < randomNumber) {
                lastLower = userGuess;
                System.out.println("NUMBER IS HIGHER, TRY AGAIN. HINT: " + lastLower + " < ? < " + lastUpper);
            } else {
                lastUpper = userGuess;
                System.out.println("NUMBER IS LOWER, TRY AGAIN. HINT: " + lastLower + " < ? < " + lastUpper);
            }
        } while (!isDone);
    }

    public static int[] bonusesForDevs(int... linesOfCodes){
        int[] bonusesForDevs = new int[linesOfCodes.length];
        int currentBonus = 1;
        if(linesOfCodes[0] > linesOfCodes[1]) {
            bonusesForDevs[0] = ++currentBonus;
            currentBonus--;
        } else {
            bonusesForDevs[0] = currentBonus++;
        }
        for(int i = 1; i < linesOfCodes.length - 1; i++) {
            if(linesOfCodes[i] < linesOfCodes[i + 1]) {
                if(linesOfCodes[i - 1] < linesOfCodes[i]) {
                    bonusesForDevs[i] = currentBonus++;
                } else if (linesOfCodes[i - 1] > linesOfCodes[i + 1]) {
                    bonusesForDevs[i] = bonusesForDevs[i]--;
                    currentBonus--;
                }
            } else if (linesOfCodes[i] > linesOfCodes[i + 1]) {
                bonusesForDevs[i] = currentBonus--;
                if(linesOfCodes[i - 1] > linesOfCodes[i]) {
                    //do nothing
                } else if (linesOfCodes[i - 1] > linesOfCodes[i + 1]) {
                    currentBonus--;
                }
            }
        }
        if(linesOfCodes[linesOfCodes.length - 1] > linesOfCodes[linesOfCodes.length - 2]){
            bonusesForDevs[linesOfCodes.length - 1] = bonusesForDevs[linesOfCodes.length - 2] + 1;
        } else {
            bonusesForDevs[linesOfCodes.length - 1] = bonusesForDevs[linesOfCodes.length - 2] - 1;
        }
        bonusesForDevs = fixBonuses(bonusesForDevs);
        return bonusesForDevs;
    }

    public static int[] fixBonuses(int[] bonuses){
        int min = Integer.MAX_VALUE;
        int[] arrayToReturn = Arrays.copyOf(bonuses, bonuses.length);
        for(int i = 0; i < bonuses.length; i++){
            min = Math.min(bonuses[i], min);
        }
        if(min <= 0) {
            int addition = 1 - min;
            for(int i = 0; i < bonuses.length; i++){
                arrayToReturn[i] += addition;
            }
        }
        return arrayToReturn;
    }

    private static int generateRandomNumber(int lowerRange, int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange - lowerRange) + lowerRange;
    }

    public static void taskOne(){
        String message = "0";

        if(message.matches("[0-9]+")) {
            System.out.println("0-9");
        }

        Pattern pattern = Pattern.compile("[0-9]+");

        Matcher matcher1 = pattern.matcher(message);
        Matcher matcher2 = pattern.matcher("ja");
        Matcher matcher3 = pattern.matcher("3");
    }

    public static void main(String[] args) {
        //taskOne();
        //taskEighteen();
        //guessGame(0, 1000);
        int[] bonuses = bonusesForDevs(10, 40, 200, 1000, 60, 1);
        System.out.println(Arrays.toString(bonuses));
    }

    public static void taskEighteen(){
        String userInput = getInputFromUserWithMessage("ENTER TEXT: ");
        String foundedSubstring = findSubstringForRegex("a+ psik", userInput);
        if(foundedSubstring.isEmpty()) {
            System.out.println("OKEJ");
        }else{
            System.out.println("NA ZDROWIE");
            System.out.println(foundedSubstring);
        }
    }

    public static String findSubstringForRegex(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            return matcher.group();
        } else {
            return "";
        }
    }

    private static String getInputFromUserWithMessage(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(s);
        return scanner.nextLine();
    }
}

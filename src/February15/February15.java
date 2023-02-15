package February15;

import java.util.Arrays;
import java.util.Scanner;

public class February15 {

    //0(n * m)
    public static void taskExtra(int[] firstArray, int[] secondArray){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(secondArray));
        System.out.println("NUMBER: ");
        int userInput = scanner.nextInt();
        for(int i = 0; i < firstArray.length; i++){
            int sum = 0;
            for (int j = 0; j < secondArray.length; j++){
                sum = firstArray[i] + secondArray[j];
                if(sum == userInput){
                    System.out.println(firstArray[i] + " + " + secondArray[j] + " = " + userInput);
                }
            }
        }
    }

    public static float addition(float firstNumber, float secondNumber){
        return firstNumber + secondNumber;
    }

    public static float subtraction(float firstNumber, float secondNumber){
        return firstNumber - secondNumber;
    }

    public static float division(float firstNumber, float secondNumber){
        if(secondNumber != 0){
            return firstNumber / secondNumber;
        }else{
            return Integer.MAX_VALUE;
        }
    }

    public static float multiplication(float firstNumber, float secondNumber){
        return firstNumber * secondNumber;
    }

    public static float calculator(String operation, float firstNumber, float secondNumber){
        switch (operation){
            case "+" -> {
                return addition(firstNumber, secondNumber);
            }
            case "-" -> {
                return subtraction(firstNumber, secondNumber);
            }
            case "*" -> {
                return multiplication(firstNumber, secondNumber);
            }
            case "/" -> {
                if(secondNumber != 0){
                    return division(firstNumber, secondNumber);
                }else{
                    return Integer.MAX_VALUE;
                }
            }
            default -> {
                return Integer.MIN_VALUE;
            }
        }
    }

    public static void taskOne(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("FIRST NUMBER: ");
        float firstNumber = scanner.nextFloat();
        System.out.println("'+' - addition \t '-' - subtraction \t '*' - multiplication \t '/' - division"  );
        System.out.print("OPERATION: " );
        String operation = scanner.next();
        System.out.print("SECOND NUMBER: ");
        float secondNumber = scanner.nextFloat();
        float result = calculator(operation, firstNumber, secondNumber);
        if(result == Integer.MAX_VALUE){
            System.out.println("ERROR");
        } else if (result == Integer.MIN_VALUE) {
            System.out.println("NOT IMPLEMENTED");
        }else{
            System.out.println(firstNumber + operation + secondNumber + "=" + result);
        }
    }

    public static void taskTwo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("NUMBER OF WAVES: ");
        int numberOfWaves = scanner.nextInt();
        System.out.print("HEIGHT OF WAVE: ");
        int heightOfWave = scanner.nextInt();
        String character = "*";
        String result = "";

        for(int i = 0; i < heightOfWave; i++){
            for(int j = 0; j < numberOfWaves; j++){
                //WHITESPACE BEFORE WAVE
                result = result.concat(printWhitespaceNTimes(i));
                //WAVE
                result = result.concat(character);
                //NUMBER OF WHITESPACE BETWEEN WAVE
                int whitesSpaceInBetween = (heightOfWave * 2) - (2 * i) - 2;
                result = result.concat(printWhitespaceNTimes(whitesSpaceInBetween));
                //WAVE
                result = result.concat(character);
                //WHITESPACE AFTER WAVE
                result = result.concat(printWhitespaceNTimes(i));
            }
            result = result.concat("\n");
        }
        System.out.println(result);
    }

    public static String printWhitespaceNTimes(int times){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < times; i++){
            stringBuilder.insert(i," ");
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        //taskOne();
        int[] firstArrayExample = {-1, 3, 8, 2, 9, 5};
        int[] secondArrayExample = {4, 1, 2, 10, 5, 20};
        //taskExtra(firstArrayExample, secondArrayExample);
        taskTwo();
    }
}

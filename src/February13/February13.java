package February13;

import java.util.Scanner;

public class February13 {

    public static void taskOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER DIAMETER OF CIRCLE: ");
        float diameter = scanner.nextFloat();
        float pi = 3.14f;
        System.out.println(diameter + " * " + Math.PI + " = " + (diameter * Math.PI));
        System.out.println(diameter + " * " + pi + " = " + (diameter * pi));
    }

    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WEIGHT: ");
        float weight = scanner.nextFloat();
        System.out.println("HEIGHT: ");
        int height = scanner.nextInt();
        double bmi = weight / Math.pow((height / 100f),2);
        System.out.println(bmi);
        if((bmi >= 18.5d) && (bmi <= 24.9)){
            System.out.println("BMI OK");
        }else{
            System.out.println("BMI not OK");
        }
    }

    //W podanym ciągu znaków znajdź najdłuższy podciąg składający się z jednego znaku np. AABCDDBBBEA -> “B:3”
    //Ciąg to tablica Stringów dowolnej wielkości. Nie używaj w zadaniu Kolekcji (Collections tzn List, Setów itp.).
    public static void taskExtra(String... array) {
        if(array.length == 0) {
            System.out.println("NO STRINGS");
            return;
        }
        int firstNotEmpty = -1;
        for(int i = 0; i < array.length; i++) {
            if(!array[i].isEmpty()) {
                firstNotEmpty = i;
            }
        }
        if(firstNotEmpty == -1){
            System.out.println("ALL EMPTY STRINGS");
            return;
        }
        int currentLongestCounterOfCharacter = -1;
        int currentCharacterCounter = 0;
        char currentChar = array[firstNotEmpty].charAt(0);
        char longestChar = array[firstNotEmpty].charAt(0);
        for(int i = firstNotEmpty; i < array.length; i++) {
            for(int j = 0; j < array[i].length(); j++) {
                if(currentChar == array[i].charAt(j)) {
                    currentCharacterCounter++;
                }else {
                    if(currentLongestCounterOfCharacter < currentCharacterCounter){
                        currentLongestCounterOfCharacter = currentCharacterCounter;
                        longestChar = currentChar;
                    }
                    currentCharacterCounter = 1;
                    currentChar = array[i].charAt(j);
                }
            }
        }
        if(currentLongestCounterOfCharacter < currentCharacterCounter) {
            currentLongestCounterOfCharacter = currentCharacterCounter;
            longestChar = currentChar;
        }
        System.out.println("LONGEST CHAIN OF CHARACTER IS: '" + longestChar + "' WITH " + currentLongestCounterOfCharacter + " times");
        System.out.println(longestChar + ":" + currentLongestCounterOfCharacter);
    }

    public static void taskThree(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("A: ");
        int a = scanner.nextInt();
        System.out.println("B: ");
        int b = scanner.nextInt();
        System.out.println("C: ");
        int c = scanner.nextInt();

        double delta = Math.pow(b,2) - (4 * a * c);

        if(delta < 0) {
            System.out.println("Delta ujemna");
        } else if (delta == 0) {
            double x = (-b) / (2d*a);
            System.out.println("X0 = " + x);
        } else {
            double x1 = (-b-Math.sqrt(delta))/(2*a);
            double x2 = (-b+Math.sqrt(delta))/(2*a);
            System.out.println("X1 = " + x1 + "\nX2 = " + x2);
        }
    }

    public static void taskFour(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("NUMBER: ");
        int userInput = scanner.nextInt();
        for(int i = 1; i <= userInput; i++){
            System.out.print(i);
            if(i % 3 == 0 && i % 7 == 0) {
                System.out.print(" Pif paf");
            } else if (i % 3 == 0) {
                System.out.print(" Pif");
            } else if (i % 7 == 0) {
                System.out.print(" Paf");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //taskExtra("");
        //taskExtra();
        //taskExtra("","bb","+++++++","dijhasohfas","123355555555");
        //taskExtra("asfasfm,", "ala ma kota", "          ");
        //taskExtra("AABCDDBBBEA");
        //taskThree();
        //taskFour();
    }
}

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
            System.out.println("BMI optymalne");
        }else{
            System.out.println("BMI nie optymalne");
        }
    }

    public static void taskExtra(String... array){
        if(array.length == 0 || array[0].isEmpty()){
            System.out.println("NO STRINGS OR STRING EMPTY");
            return;
        }
        int currentLongestCounterOfCharacter = -1;
        int currentCharacterCounter = 1;
        char currentChar = array[0].charAt(0);
        char longestChar = array[0].charAt(0);
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length(); j++){
                if(currentChar == array[i].charAt(j)){
                    currentCharacterCounter++;
                }else{
                    if(currentLongestCounterOfCharacter < currentCharacterCounter){
                        currentLongestCounterOfCharacter = currentCharacterCounter;
                        longestChar = currentChar;
                    }
                    currentCharacterCounter = 1;
                    currentChar = array[i].charAt(j);
                }
            }
        }
        if(currentLongestCounterOfCharacter < currentCharacterCounter){
            currentLongestCounterOfCharacter = currentCharacterCounter;
            longestChar = currentChar;
        }
        System.out.println("LONGEST CHAIN OF CHARACTER IS: \'" + longestChar + "\' WITH " + currentLongestCounterOfCharacter + " times");
        System.out.println(longestChar + ":" + currentLongestCounterOfCharacter);
    }

    //W podanym ciągu znaków znajdź najdłuższy podciąg składający się z jednego znaku np. AABCDDBBBEA -> “B:3”
    //Ciąg to tablica Stringów dowolnej wielkości. Nie używaj w zadaniu Kolekcji (Collections tzn List, Setów itp.).
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
            float x = (-b) / (2*a);
            System.out.println("X0 = " + x);
        } else {
            float x1 = (float) ((-b-Math.sqrt(delta))/(2*a));
            float x2 = (float) ((-b+Math.sqrt(delta))/(2*a));
            System.out.println("X1 = " + x1 + "\nX2 = " + x2);
        }
    }

    public static void main(String[] args) {
        //taskExtra("");
        //taskExtra();
        //taskExtra("aaa","bb","+++++++","dijhasohfas","123355555555");
        //taskExtra("asfasfm,", "ala ma kota", "          ");
        taskThree();
    }
}

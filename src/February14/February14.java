package February14;

import java.util.Arrays;
import java.util.Scanner;

public class February14 {
    public static void taskFive(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("NUMBER: ");
        int userInput = scanner.nextInt();
        boolean isPrime;
        NUMBER: for(int i = 2; i < userInput; i++){
            isPrime = true;
            MODULO: for(int j = 2; j < i; j++){
                if(i % j == 0){
                    isPrime = false;
                    break MODULO;
                }
            }
            if(isPrime){
                System.out.print(i + "\t");
            }
        }
    }

    //Mając listę liczb i liczbę k, zwróć, czy dowolne dwie liczby z listy sumują się do k.
    //Na przykład, biorąc pod uwagę [10, 15, 3, 7] i k z 17, zwróć prawdę, ponieważ 10 + 7 to 17. Nie używaj Kolekcji (Collections - List, Setów itp.).
    public static boolean taskExtra(int k, int... numbers){
        int sum;
        A: for(int i = 0; i < (numbers.length - 1); i++){
            B: for(int j = (i + 1); j < numbers.length; j++){
                sum = numbers[i] + numbers[j];
                if(sum == k) return true;
            }
        }
        return false;
    }

    public static void taskSix(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("NUMBER: ");
        int userInput = scanner.nextInt();

        double harmonicSeries = 1d;
        for (int i = 2; i <= userInput; i++) {
            harmonicSeries += 1d / i;
        }
        System.out.println("HARMONIC SERIES FOR " + userInput + " equals : " + harmonicSeries);
    }

    //Napisz program usuwający duplikaty z tablicy i zwracający nową tablicę, np.
    //Tablica wejściowa: [20, 20, 30, 40, 50, 50, 50],
    //Tablica wyjściowa: [20, 30, 40, 50]
    //
    public static int[] deleteDuplicateNumbers(int[] numbers){
        //Sortowanie
        for(int i = 0; i < numbers.length; i++){
        }
        return null;
    }

    //Wskaż liczbę o 1 większą od reprezentowanej liczby przez cyfry w tablicy, np. [1,3,2,4] -> 1324 + 1 -> [1,3,2,5]
    //w zasadzie to zadanie jest lepsze, tamto podam też grupie
    // ja [9] -> [1, 0]
    // [8,9] -> [9, 0]
    public static int[] addOneToNumber(int[] number){
        int[] arrayToCalculate = Arrays.copyOf(number, number.length);
        int carryOn = 1;
        int lastIndex = number.length - 1;
        do{
            if(lastIndex < 0){
                int[] arrayToReturn = new int[number.length + 1];
                for(int i = 1; i < arrayToCalculate.length; i++){
                    arrayToReturn[i] = arrayToCalculate[i];
                }
                arrayToReturn[0] = carryOn;
                return arrayToReturn;
            }
            arrayToCalculate[lastIndex] = number[lastIndex] + carryOn;
            carryOn = arrayToCalculate[lastIndex] / 10;
            arrayToCalculate[lastIndex] %= 10;
            lastIndex--;
        }while(carryOn != 0);
        return arrayToCalculate;
    }

    public static int fibonacci(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void fibonacciLoop(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("NUMBER: ");
        int userInput = scanner.nextInt();
        //System.out.println("RECURSION: F(" + userInput + ")=" + fibonacci(userInput));
        int prevFibonacci = 1;
        int secondPreviousFibonacci = 1;
        int currentSumOfFibonacci = 1;
        for(int i = 2; i < userInput; i++){
            currentSumOfFibonacci = prevFibonacci + secondPreviousFibonacci;
            secondPreviousFibonacci = prevFibonacci;
            prevFibonacci = currentSumOfFibonacci;
        }
        System.out.println("NUMBER FIBONACCI " + userInput + " : " + currentSumOfFibonacci);
    }


    public static void main(String[] args) {
        int[] exampleForAddOne = {1,3,2,4};
        int[] exampleForAddOneTricky = {9};
        //System.out.println(taskExtra(25,10, 15, 3 , 7));
        //System.out.println(Arrays.toString(addOneToNumber(exampleForAddOneTricky)));
        fibonacciLoop();
    }
}

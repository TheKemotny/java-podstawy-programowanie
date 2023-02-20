import java.util.Scanner;

public class Helper {
    public static String getInputFromUserWithMessage(String message){
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

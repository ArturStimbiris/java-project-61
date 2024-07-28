package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        Scanner scannerM = new Scanner(System.in);
        var greeting = new Greeting();
        var choice = scannerM.next();
        System.out.println();
        switch (choice) {
            case "1":
                System.out.println("Your choice - " + choice);
                greeting.greeting();
                break;
            case "2":
                System.out.println("Your choice - " + choice);
                Even even = new Even(3);
                even.gameEven();
                break;
            case "0":
                System.out.println("Your choice - " + choice);
                break;
            default:
                System.out.println("Not allowed choice - " + choice + ". Bue!");
        }
    }
}

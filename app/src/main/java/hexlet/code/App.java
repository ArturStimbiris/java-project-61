package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("0 - Exit");
        Scanner scannerM = new Scanner(System.in);
        var greeting = new Greeting();
        var choice = "";
        try {
            choice = scannerM.next();
        } catch (Exception e) {
            System.out.println("Ошибка: Пожалуйста, введите корректные данные.");
        }
        System.out.println();
        switch (choice) {
            case "1":
                System.out.println("Your choice - " + choice);
                greeting.greeting();
                break;
            case "2":
                System.out.println("Your choice - " + choice);
                Even even = new Even(3);
                even.game();
                break;
            case "3":
                System.out.println("Your choice - " + choice);
                Calc calc = new Calc(3);
                calc.game();
                break;
            case "4":
                System.out.println("Your choice - " + choice);
                GCD gcd = new GCD(3);
                gcd.game();
                break;
            case "5":
                System.out.println("Your choice - " + choice);
                Progression progression = new Progression(3);
                progression.game();
                break;
            case "0":
                System.out.println("Your choice - " + choice);
                break;
            default:
                System.out.println("Not allowed choice - " + choice + ". Bue!");
        }
    }
}

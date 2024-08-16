package hexlet.code;
import java.util.Scanner;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class App {
    public static final int choiceOne = 1;
    public static final int choiceTwo = 2;
    public static final int choiceThree = 3;
    public static final int choiceFour = 4;
    public static final int choiceFive = 5;
    public static final int choiceSix = 6;
    public static final int choiceZero = 0;
    public static void main(String[] args) {
        var choice = mainMenu();
        var countOfAttempts = 3; //Count for all attempts in any game
        switch (choice) {
            case choiceOne: //Select menu number "1"
                System.out.println("Your choice - " + choice);
                Engine.greeting();
                break;
            case choiceTwo: //Select menu number "2"
                System.out.println("Your choice - " + choice);
                Even.game(countOfAttempts);
                break;
            case choiceThree: //Select menu number "3"
                System.out.println("Your choice - " + choice);
                Calc.game(countOfAttempts);
                break;
            case choiceFour: //Select menu number "4"
                System.out.println("Your choice - " + choice);
                GCD.game(countOfAttempts);
                break;
            case choiceFive: //Select menu number "5"
                System.out.println("Your choice - " + choice);
                Progression.game(countOfAttempts);
                break;
            case choiceSix: //Select menu number "6"
                System.out.println("Your choice - " + choice);
                Prime.game(countOfAttempts);
                break;
            case choiceZero: //Select menu number "0"
                System.out.println("Your choice - " + choice);
                break;
            default:
                System.out.println("Not allowed choice - " + choice + ". Bue!");
        }
    }
    public static int mainMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        Scanner scannerM = new Scanner(System.in);
        var choiceInMainMenu = 0;
        try {
            choiceInMainMenu = scannerM.nextInt();
        } catch (Exception e) {
            System.out.println("Error. Incorrect input.");
        }
        System.out.println();
        return choiceInMainMenu;
    }
}

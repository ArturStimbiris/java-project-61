package hexlet.code;
import java.util.Scanner;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class App {
    public static final int CHOICE_ONE = 1;
    public static final int CHOICE_TWO = 2;
    public static final int CHOICE_THREE = 3;
    public static final int CHOICE_FOUR = 4;
    public static final int CHOICE_FIVE = 5;
    public static final int CHOICE_SIX = 6;
    public static final int CHOICE_ZERO = 0;
    public static void main(String[] args) {
        var choice = mainMenu();
        switch (choice) {
            case CHOICE_ONE: //Select menu number "1"
                System.out.println("Your choice - " + choice);
                Engine.greeting();
                break;
            case CHOICE_TWO: //Select menu number "2"
                System.out.println("Your choice - " + choice);
                Even.game();
                break;
            case CHOICE_THREE: //Select menu number "3"
                System.out.println("Your choice - " + choice);
                Calc.game();
                break;
            case CHOICE_FOUR: //Select menu number "4"
                System.out.println("Your choice - " + choice);
                GCD.game();
                break;
            case CHOICE_FIVE: //Select menu number "5"
                System.out.println("Your choice - " + choice);
                Progression.game();
                break;
            case CHOICE_SIX: //Select menu number "6"
                System.out.println("Your choice - " + choice);
                Prime.game();
                break;
            case CHOICE_ZERO: //Select menu number "0"
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

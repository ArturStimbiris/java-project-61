package hexlet.code;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class App {
    public static void main(String[] args) {
        var choice = Engine.mainMenu();
        var countOfAttempts = 3; //Count for all attempts in any game
        switch (choice) {
            case 1: //Select menu number "1"
                System.out.println("Your choice - " + choice);
                Engine.greeting();
                break;
            case 2: //Select menu number "2"
                System.out.println("Your choice - " + choice);
                Even.game(countOfAttempts);
                break;
            case 3: //Select menu number "3"
                System.out.println("Your choice - " + choice);
                Calc.game(countOfAttempts);
                break;
            case 4: //Select menu number "4"
                System.out.println("Your choice - " + choice);
                GCD.game(countOfAttempts);
                break;
            case 5: //Select menu number "5"
                System.out.println("Your choice - " + choice);
                Progression.game(countOfAttempts);
                break;
            case 6: //Select menu number "6"
                System.out.println("Your choice - " + choice);
                Prime.game(countOfAttempts);
                break;
            case 0: //Select menu number "0"
                System.out.println("Your choice - " + choice);
                break;
            default:
                System.out.println("Not allowed choice - " + choice + ". Bue!");
        }
    }
}

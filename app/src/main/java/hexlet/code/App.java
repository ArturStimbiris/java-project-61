package hexlet.code;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class App {
    public static void main(String[] args) {
        var choice = Engine.mainMenu();
        var countOfAttempts = 3;
        switch (choice) {
            case 1:
                System.out.println("Your choice - " + choice);
                Engine.greeting();
                break;
            case 2:
                System.out.println("Your choice - " + choice);
                Even.game(countOfAttempts);
                break;
            case 3:
                System.out.println("Your choice - " + choice);
                Calc.game(countOfAttempts);
                break;
            case 4:
                System.out.println("Your choice - " + choice);
                GCD.game(countOfAttempts);
                break;
            case 5:
                System.out.println("Your choice - " + choice);
                Progression.game(countOfAttempts);
                break;
            case 6:
                System.out.println("Your choice - " + choice);
                Prime.game(countOfAttempts);
                break;
            case 0:
                System.out.println("Your choice - " + choice);
                break;
            default:
                System.out.println("Not allowed choice - " + choice + ". Bue!");
        }
    }
}

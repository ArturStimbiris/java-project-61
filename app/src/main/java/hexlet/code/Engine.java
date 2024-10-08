package hexlet.code;
import java.util.Scanner;

public class Engine {
    public static final int COUNT_OF_ATTEMPTS = 3;

    public static String greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        var userName = "";
        var scanner = new Scanner(System.in);
        try {
            userName = scanner.next();
        } catch (Exception e) {
            userName = "";
        }
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void playGame(String[][] questionsAndAnswers, String rules) {
        var userName = greeting();
        System.out.println(rules);
        var win = false;
        for (int i = 0; i < COUNT_OF_ATTEMPTS; i++) {
            System.out.println(questionsAndAnswers[i][0]);
            win = attempt(questionsAndAnswers[i][1]);
            if (!win) {
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (win) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    public static boolean attempt(String answer) {
        String choice = "";
        var scannerAttempChoice = new Scanner(System.in);
        try {
            choice = scannerAttempChoice.next();
        } catch (Exception e) {
            System.out.println("Illegal input");
        }
        if (answer.equals(choice)) {
            System.out.println("Your answer: " + choice);
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Your answer: " + choice);
            System.out.println("'" + choice + "' is wrong answer ;(. Correct answer was '" + answer + "'.");
            return false;
        }
    }
}

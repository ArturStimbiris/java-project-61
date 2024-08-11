package hexlet.code;
import java.util.Scanner;

public class Engine {
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
    public static boolean attemptForYesNo(String gameAnswer) {
        var attemptChoice = "";
        var scannerAttempChoice = new Scanner(System.in);
        try {
            attemptChoice = scannerAttempChoice.next();
        } catch (Exception e) {
            System.out.println("Illegal input");
        }
        System.out.println("Your answer: " + attemptChoice);
        switch (attemptChoice) {
            case "yes":
                if (gameAnswer.equals("yes")) {
                    System.out.println("Correct!");
                    return true;
                } else {
                    System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                    return false;
                }
            case "no":
                if (gameAnswer.equals("no")) {
                    System.out.println("Correct!");
                    return true;
                } else {
                    System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                    return false;
                }
            default:
                System.out.println("Not allowed choice - " + attemptChoice + ". Bue!");
                return false;
        }
    }
    public static boolean attemptForNumber(int gameAnswer) {
        int choice = 0;
        var scannerAttempChoice = new Scanner(System.in);
        try {
            choice = scannerAttempChoice.nextInt();
        } catch (Exception e) {
            System.out.println("Illegal input");
        }
        if (gameAnswer == choice) {
            System.out.println("Your answer: " + choice);
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Your answer: " + choice);
            System.out.println("'" + choice + "' is wrong answer ;(. Correct answer was '" + gameAnswer + "'.");
            return false;
        }
    }
    public static void playGame(int countOfAttempts, String[] gameQuestions, String[] gameAnswers, String firstText) {
        var userName = greeting();
        System.out.println(firstText);
        var win = false;
        for (int i = 0; i < countOfAttempts; i++) {
            System.out.println(gameQuestions[i]);
            win = attemptForYesNo(gameAnswers[i]);
            if (!win) {
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (win) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
    public static void playGame(int countOfAttempts, String[] gameQuestions, int[] gameAnswers, String firstText) {
        var userName = greeting();
        System.out.println(firstText);
        var win = false;
        for (int i = 0; i < countOfAttempts; i++) {
            System.out.println(gameQuestions[i]);
            win = attemptForNumber(gameAnswers[i]);
            if (!win) {
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (win) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}

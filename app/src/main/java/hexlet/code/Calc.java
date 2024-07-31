package hexlet.code;
import java.util.Scanner;
import java.util.Random;

class Calc {
    private int countOfAttempts;
    private boolean win;
    private Scanner scan;

    Calc(int countOfAttempts) {
        this.countOfAttempts = countOfAttempts;
        win = true;
        scan = new Scanner(System.in);
    }

    public void attempt() {
        Random random = new Random();
        var numberOne = random.nextInt(20);
        var numberTwo = random.nextInt(20);
        int result = 0;
        var symbol = "";
        var matchVariant = random.nextInt(1, 4);
        switch (matchVariant) {
            case 1:
                result = numberOne + numberTwo;
                symbol = "+";
                break;
            case 2:
                result = numberOne - numberTwo;
                symbol = "-";
                break;
            case 3:
                result = numberOne * numberTwo;
                symbol = "*";
                break;
            default:
                result = 0;
        }
        System.out.println("Question: " + numberOne + " " + symbol + " " + numberTwo);
        int choice = 0;
        try {
            choice = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Illegal input");
        }
        if (result == choice) {
            System.out.println("Your answer: " + choice);
            System.out.println("Correct!");
        } else {
            System.out.println("Your answer: " + choice);
            System.out.println("'" + choice + "' is wrong answer ;(. Correct answer was '" + result + "'.");
            win = false;
        }
    }

    public void game() {
        Greeting greeting = new Greeting();
        greeting.greeting();
        System.out.println("What is the result of the expression?");
        for (int i = 0; i < countOfAttempts; i++) {
            this.attempt();
            if (!win) {
                System.out.println("Let's try again, " + greeting.getUserName() + "!");
                break;
            }
        }
        if (win) {
            System.out.println("Congratulations, " + greeting.getUserName() + "!");
        }
    }
}

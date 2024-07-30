package hexlet.code;
import java.util.Scanner;
import java.util.Random;

class GCD {
    private int countOfAttempts;
    private boolean win;
    private Scanner scan;

    GCD(int countOfAttempts) {
        this.countOfAttempts = countOfAttempts;
        win = true;
        scan = new Scanner(System.in);
    }

    public void attempt() {
        Random random = new Random();
        var numberOne = random.nextInt(1,101);
        var numberTwo = random.nextInt(1,101);
        var x = 0;
        var y = 0;
        if (numberOne >= numberTwo) {
            x = numberOne;
            y = numberTwo;
        } else if (numberOne < numberTwo) {
            x = numberTwo;
            y = numberOne;
        }
        while (y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        var result = x;
        System.out.println("Question: " + numberOne + " " + numberTwo);
        var choice = 0;
        try {
            choice = scan.nextInt();
        }
        catch (Exception e) {
            System.out.println("Illegal input");
        }
        if (result == choice) {
            System.out.println("Your answer: " + result);
            System.out.println("Correct!");
        } else {
            System.out.println("Your answer: " + result);
            System.out.println("'" + choice + "' is wrong answer ;(. Correct answer was '" + result + "'.");
            win = false;
        }
    }

    public void game() {
        Greeting greeting = new Greeting();
        greeting.greeting();
        System.out.println("Find the greatest common divisor of given numbers.");
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


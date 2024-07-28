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
        var numberOne = random.nextInt(199);
        var numberTwo = random.nextInt(199);
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
        }
        System.out.println("Question: " + numberOne + " " + symbol + " " + numberTwo);
        var choice = scan.next();
        if (result == Integer.parseInt(choice)) {
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

package hexlet.code;
import java.util.Scanner;
import java.util.Random;

class Engine {
    private int countOfAttempts;
    private boolean win;
    private Scanner scan;

    Engine(int countOfAttempts) {
        this.countOfAttempts = countOfAttempts;
        win = true;
        scan = new Scanner(System.in);
    }

    public void attempt() {
        Random random = new Random();
        var number = random.nextInt(199);
        System.out.println("Question: " + number);
        var choice = scan.next();
        switch (choice) {
            case "yes":
                System.out.println("Your answer: " + choice);
                if (number == 0) {
                    System.out.println("Correct!");
                    break;
                } else {
                    System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                    win = false;
                    break;
                }
            case "no":
                System.out.println("Your answer: " + choice);
                if (number > 0) {
                    System.out.println("Correct!");
                    break;
                } else {
                    System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                    win = false;
                    break;
                }
            default:
                System.out.println("Not allowed choice - " + choice + ". Bue!");
                win = false;
        }
    }

    public void gameEngine() {
        Greeting greeting = new Greeting();
        greeting.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
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

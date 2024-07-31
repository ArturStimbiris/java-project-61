package hexlet.code;
import java.util.Scanner;
import java.util.Random;

class Even {
    private int countOfAttempts;
    private boolean win;
    private Scanner scan;
    Even(int countOfAttempts) {
        this.countOfAttempts = countOfAttempts;
        win = true;
        scan = new Scanner(System.in);
    }
    public void attempt() {
        Random random = new Random();
        var numberEven = random.nextInt(99);
        var choiceEven = "";
        System.out.println("Question: " + numberEven);
        try {
            choiceEven = scan.next();
        } catch (Exception e) {
            System.out.println("Illegal input");
        }
        switch (choiceEven) {
            case "yes":
                System.out.println("Your answer: " + choiceEven);
                if (numberEven % 2 == 0) {
                    System.out.println("Correct!");
                    break;
                } else {
                    System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                    win = false;
                    break;
                }
            case "no":
                System.out.println("Your answer: " + choiceEven);
                if (numberEven % 2 > 0) {
                    System.out.println("Correct!");
                    break;
                } else {
                    System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                    win = false;
                    break;
                }
            default:
                System.out.println("Not allowed choice - " + choiceEven + ". Bue!");
                win = false;
        }
    }
    public void game() {
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

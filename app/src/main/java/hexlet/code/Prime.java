package hexlet.code;
import java.util.Scanner;
import java.util.Random;

class Prime {
    private int countOfAttempts;
    private boolean win;
    private Scanner scan;

    Prime(int countOfAttempts) {
        this.countOfAttempts = countOfAttempts;
        win = true;
        scan = new Scanner(System.in);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for(int i = 2; i < n / 2; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void attempt() {
        Random random = new Random();
        var number = random.nextInt(100);
        var isPrimeNumber = this.isPrime(number);
        System.out.println("Question: " + number);
        var choice = "";
        try {
            choice = scan.next();
        }
        catch (Exception e) {
            System.out.println("Illegal input");
        }
        switch (choice) {
            case "yes":
                System.out.println("Your answer: " + choice);
                if (isPrimeNumber) {
                    System.out.println("Correct!");
                    break;
                } else {
                    System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                    win = false;
                    break;
                }
            case "no":
                System.out.println("Your answer: " + choice);
                if (!isPrimeNumber) {
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

    public void game() {
        Greeting greeting = new Greeting();
        greeting.greeting();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
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



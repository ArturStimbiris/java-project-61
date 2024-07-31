package hexlet.code;
import java.util.Scanner;
import java.util.Random;

class Progression {
    private int countOfAttempts;
    private boolean win;
    private Scanner scan;

    Progression(int countOfAttempts) {
        this.countOfAttempts = countOfAttempts;
        win = true;
        scan = new Scanner(System.in);
    }

    public void attempt() {
        Random random = new Random();
        var arrLength = random.nextInt(7, 11);
        int[] numbers = new int[arrLength];
        String[] row = new String[arrLength];
        var arrayStart = random.nextInt(2, 25);
        var arrayProgression = random.nextInt(1, 7);
        var hiderPosition = random.nextInt(0, arrLength - 1);
        var text = "";
        var result = 0;
        for (int i = 0; i < arrLength; i++) {
            if (i == 0) {
                numbers[i] = arrayStart;
            } else {
                numbers[i] = numbers[i - 1] + arrayProgression;
            }
            if (i == hiderPosition) {
                row[i] = "..";
                result = numbers[i];
            } else {
                row[i] = String.valueOf(numbers[i]);
            }
            if (i == 0) {
                text = row[i];
            } else {
                text = text + " " + row[i];
            }
        }
        System.out.println("Question: " + text);
        var choice = 0;
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
        System.out.println("What number is missing in the progression?");
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


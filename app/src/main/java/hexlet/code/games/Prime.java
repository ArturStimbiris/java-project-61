package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    public static String answerBranch() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int makeAnyQuestionNumber() {
        var maxValueOfRandom = 100;
        Random random = new Random();
        return random.nextInt(maxValueOfRandom);
    }
    public static String makeGameQuestion(int firstQuestionNumber) {
        return "Question: " + firstQuestionNumber;
    }
    public static void game(int countOfAttempts) {
        String[] questions = new String[countOfAttempts];
        String[] correctAnswers = new String[countOfAttempts];
        var firstQuestion = answerBranch();
        for (var i = 0; i < countOfAttempts; i++) {
            var firstGameNumber = makeAnyQuestionNumber();
            questions[i] = makeGameQuestion(firstGameNumber);
            var isPrimeNumber = isPrime(firstGameNumber);
            if (isPrimeNumber) {
                correctAnswers[i] = "yes";
            } else {
                correctAnswers[i] = "no";
            }
        }
        Engine.playGame(countOfAttempts, questions, correctAnswers, firstQuestion);
    }
}

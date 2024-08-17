package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    public static final int MAX_VALUE_OF_RANDOM = 100;
    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
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
        Random random = new Random();
        return random.nextInt(MAX_VALUE_OF_RANDOM);
    }
    public static String makeGameQuestion(int questionNumber) {
        return "Question: " + questionNumber;
    }
    public static void game() {
        String[] questionsAndAnswers = new String[Engine.COUNT_OF_ATTEMPTS];
        for (var i = 0; i < Engine.COUNT_OF_ATTEMPTS; i++) {
            var gameNumber = makeAnyQuestionNumber();
            questionsAndAnswers[i] = makeGameQuestion(gameNumber);
            var isPrimeNumber = isPrime(gameNumber);
            if (isPrimeNumber) {
                questionsAndAnswers[i] = questionsAndAnswers[i] + ", " + "yes";
            } else {
                questionsAndAnswers[i] = questionsAndAnswers[i] + ", " + "no";;
            }
        }
        Engine.playGame(questionsAndAnswers, RULES);
    }
}

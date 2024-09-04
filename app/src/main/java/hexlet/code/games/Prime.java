package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final int MAX_VALUE_OF_RANDOM = 100;
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

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

    public static String makeQuestion(int questionNumber) {
        return "Question: " + questionNumber;
    }

    public static void game() {
        String[][] qa = new String[Engine.COUNT_OF_ATTEMPTS][2];
        for (var i = 0; i < Engine.COUNT_OF_ATTEMPTS; i++) {
            var gameNumber = Utils.getRandomNum(MAX_VALUE_OF_RANDOM);
            qa[i][0] = makeQuestion(gameNumber);
            var isPrimeNumber = isPrime(gameNumber);
            if (isPrimeNumber) {
                qa[i][1] = "yes";
            } else {
                qa[i][1] = "no";
            }
        }
        Engine.playGame(qa, RULES);
    }
}

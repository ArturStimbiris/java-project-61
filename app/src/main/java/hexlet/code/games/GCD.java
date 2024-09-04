package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final int MAX_VALUE_OF_RANDOM = 100;
    private static final String RULES = "Find the greatest common divisor of given numbers.";

    public static int gcd(int numberOne, int numberTwo) {
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
        return x;
    }

    public static String makeQuestion(int firstQuestionNumber, int secondQuestionNumber) {
        return "Question: " + firstQuestionNumber + " " + secondQuestionNumber;
    }

    public static void game() {
        String[][] qa = new String[Engine.COUNT_OF_ATTEMPTS][2];
        for (var i = 0; i < Engine.COUNT_OF_ATTEMPTS; i++) {
            var firstNumber = Utils.getRandomNum(MAX_VALUE_OF_RANDOM);
            var secondNumber = Utils.getRandomNum(MAX_VALUE_OF_RANDOM);
            qa[i][0] = makeQuestion(firstNumber, secondNumber);
            qa[i][1] = String.valueOf(gcd(firstNumber, secondNumber));
        }
        Engine.playGame(qa, RULES);
    }
}


package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class GCD {
    public static final int MAX_VALUE_OF_RANDOM = 100;
    public static final String RULES = "Find the greatest common divisor of given numbers.";
    public static int gcdForTwoNumbers(int numberOne, int numberTwo) {
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
    public static int makeAnyQuestionNumber() {
        Random random = new Random();
        return random.nextInt(MAX_VALUE_OF_RANDOM);
    }
    public static String makeGameQuestion(int firstQuestionNumber, int secondQuestionNumber) {
        return "Question: " + firstQuestionNumber + " " + secondQuestionNumber;
    }
    public static void game() {
        String[] questions = new String[Engine.COUNT_OF_ATTEMPTS];
        int[] correctAnswers = new int[Engine.COUNT_OF_ATTEMPTS];
        for (var i = 0; i < Engine.COUNT_OF_ATTEMPTS; i++) {
            var firstGameNumber = makeAnyQuestionNumber();
            var secondGameNumber = makeAnyQuestionNumber();
            questions[i] = makeGameQuestion(firstGameNumber, secondGameNumber);
            correctAnswers[i] = gcdForTwoNumbers(firstGameNumber, secondGameNumber);
        }
        Engine.playGame(questions, correctAnswers, RULES);
    }
}


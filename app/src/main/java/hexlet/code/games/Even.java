package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final int MAX_VALUE_OF_RANDOM = 100;
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static boolean isEven(int n) {
        if (n % 2 > 0) {
            return false;
        }
        return true;
    }

    public static String makeQuestion(int questionNumber) {
        return "Question: " + questionNumber;
    }

    public static void game() {
        String[][] qa = new String[Engine.COUNT_OF_ATTEMPTS][2];
        for (var i = 0; i < Engine.COUNT_OF_ATTEMPTS; i++) {
            var questionNumber = Utils.getRandomNum(MAX_VALUE_OF_RANDOM);
            qa[i][0] = makeQuestion(questionNumber);
            var isEvenNumber = isEven(questionNumber);
            if (isEvenNumber) {
                qa[i][1] = "yes";
            } else {
                qa[i][1] = "no";
            }
        }
        Engine.playGame(qa, RULES);
    }
}

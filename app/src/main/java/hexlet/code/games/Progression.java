package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final int MIN_VAL_FOR_DEPENDENCY = 1;
    private static final int MAX_VAL_FOR_DEPENDENCY = 7;
    private static final int MAX_VAL_FOR_START_NUMBER = 25;
    private static final int MIN_VAL_PROGR_LENGTH = 7;
    private static final int MAX_VAL_PROGR_LENGTH = 11;
    private static final String RULES = "What number is missing in the progression?";

    public static int[] makeProgression(int startNumber, int dependency, int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                numbers[i] = startNumber;
            } else {
                numbers[i] = numbers[i - 1] + dependency;
            }
        }
        return numbers;
    }

    public static String makeProgressionInText(int[] numbers, int hiddenElementPosition) {
        var progressionInText = "";
        String[] row = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (i == hiddenElementPosition) {
                row[i] = "..";
            } else {
                row[i] = String.valueOf(numbers[i]);
            }
            if (i == 0) {
                progressionInText = row[i];
            } else {
                progressionInText = progressionInText + " " + row[i];
            }
        }
        return progressionInText;
    }

    public static String makeQuestion(String progressionInText) {
        return "Question: " + progressionInText;
    }

    public static void game() {
        String[] qa = new String[Engine.COUNT_OF_ATTEMPTS];
        for (var i = 0; i < Engine.COUNT_OF_ATTEMPTS; i++) {
            var length = Utils.getRandomNum(MIN_VAL_PROGR_LENGTH, MAX_VAL_PROGR_LENGTH);
            var dependency = Utils.getRandomNum(MIN_VAL_FOR_DEPENDENCY, MAX_VAL_FOR_DEPENDENCY);
            var startNumber = Utils.getRandomNum(MAX_VAL_FOR_START_NUMBER);
            var hiddenElemint = Utils.getRandomNum(0, length - 1);
            int[] progression = makeProgression(startNumber, dependency, length);
            var progressionInText = makeProgressionInText(progression, hiddenElemint);
            qa[i] = makeQuestion(progressionInText) + ", " + progression[hiddenElemint];
        }
        Engine.playGame(qa, RULES);
    }
}


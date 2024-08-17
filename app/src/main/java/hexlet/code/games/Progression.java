package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    public static final int MIN_VAL_FOR_DEPENDENCY = 1;
    public static final int MAX_VAL_FOR_DEPENDENCY = 7;
    public static final int MAX_VAL_FOR_START_NUMBER = 25;
    public static final int MIN_VAL_PROGR_LENGTH = 7;
    public static final int MAX_VAL_PROGR_LENGTH = 11;
    public static final String RULES = "What number is missing in the progression?";
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
    public static int makeDependency() {
        Random random = new Random();
        return random.nextInt(MIN_VAL_FOR_DEPENDENCY, MAX_VAL_FOR_DEPENDENCY);
    }
    public static int makeStartNumber() {
        Random random = new Random();
        return random.nextInt(MAX_VAL_FOR_START_NUMBER);
    }
    public static int makeLenght() {
        Random random = new Random();
        return random.nextInt(MIN_VAL_PROGR_LENGTH, MAX_VAL_PROGR_LENGTH);
    }
    public static int makeHiddenElement(int progressionLength) {
        var minValueOfRandom = 0;
        var maxValueOfRandom = progressionLength - 1;
        Random random = new Random();
        return random.nextInt(minValueOfRandom, maxValueOfRandom);
    }
    public static String makeQuestion(String progressionInText) {
        return "Question: " + progressionInText;
    }
    public static void game() {
        String[] qa = new String[Engine.COUNT_OF_ATTEMPTS];
        for (var i = 0; i < Engine.COUNT_OF_ATTEMPTS; i++) {
            var length = makeLenght();
            var dependency = makeDependency();
            var startNumber = makeStartNumber();
            var hiddenElemint = makeHiddenElement(length);
            int[] progression = makeProgression(startNumber, dependency, length);
            var progressionInText = makeProgressionInText(progression, hiddenElemint);
            qa[i] = makeQuestion(progressionInText) + ", " + progression[hiddenElemint];
        }
        Engine.playGame(qa, RULES);
    }
}


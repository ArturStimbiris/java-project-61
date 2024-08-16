package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    public static final int minValueOfRandomForDependency = 1; //Make min value of random number for progression dependency
    public static final int maxValueOfRandomForDependency = 7; //Make max value of random number for progression dependency
    public static final int maxValueOfRandomForStartNumber = 25; //Make max value of random number for progression start number
    public static final int minValueOfRandomForProgressionLength = 7; //Make min value of random number for progression length
    public static final int maxValueOfRandomForProgressionLength = 11; //Make max value of random number for progression length
    public static String answerBranch() {
        return "What number is missing in the progression?";
    }
    public static int[] makeProgression(int progressionStartNumber, int progressionDependency, int progressionLength) {
        int[] numbers = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            if (i == 0) {
                numbers[i] = progressionStartNumber;
            } else {
                numbers[i] = numbers[i - 1] + progressionDependency;
            }
        }
        return numbers;
    }
    public static String makeProgressionInText(int[] numbers, int progressionHiddenElementPosition) {
        var progressionInText = "";
        String[] row = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (i == progressionHiddenElementPosition) {
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
    public static int makeProgressionDependency() {
        Random random = new Random();
        return random.nextInt(minValueOfRandomForDependency, maxValueOfRandomForDependency);
    }
    public static int makeProgressionStartNumber() {
        Random random = new Random();
        return random.nextInt(maxValueOfRandomForStartNumber);
    }
    public static int makeProgressionLenght() {
        Random random = new Random();
        return random.nextInt(minValueOfRandomForProgressionLength, maxValueOfRandomForProgressionLength);
    }
    public static int makeProgressionHiddenElementPosition(int progressionLength) {
        var minValueOfRandom = 0;
        var maxValueOfRandom = progressionLength - 1;
        Random random = new Random();
        return random.nextInt(minValueOfRandom, maxValueOfRandom);
    }
    public static String makeGameQuestion(String progressionInText) {
        return "Question: " + progressionInText;
    }
    public static void game(int countOfAttempts) {
        String[] questions = new String[countOfAttempts];
        int[] correctAnswers = new int[countOfAttempts];
        var firstQuestion = answerBranch();
        for (var i = 0; i < countOfAttempts; i++) {
            var progressionLength = makeProgressionLenght();
            var progressionDependency = makeProgressionDependency();
            var progressionStartNumber = makeProgressionStartNumber();
            var progressionHiddenElementPosition = makeProgressionHiddenElementPosition(progressionLength);
            int[] progression = makeProgression(progressionStartNumber, progressionDependency, progressionLength);
            var progressionInText = makeProgressionInText(progression, progressionHiddenElementPosition);
            questions[i] = makeGameQuestion(progressionInText);
            correctAnswers[i] = progression[progressionHiddenElementPosition];
        }
        Engine.playGame(countOfAttempts, questions, correctAnswers, firstQuestion);
    }
}


package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Calc {
    public static String answerBranch() {
        return "What is the result of the expression?";
    }
    public static int resultForOperation(int numberOne, int numberTwo, int machVariant) {
        switch (machVariant) {
            case 1:
                return numberOne + numberTwo;
            case 2:
                return numberOne - numberTwo;
            case 3:
                return numberOne * numberTwo;
            default:
                return 0;
        }
    }
    public static Character makeCharacterForThisMathOperation(int machVariant) {
        switch (machVariant) {
            case 1:
                return '+';
            case 2:
                return '-';
            case 3:
                return '*';
            default:
                return null;
        }
    }
    public static int makeMathVariant() {
        var minValueOfRandom = 1;
        var maxValueOfRandom = 4;
        Random random = new Random();
        return random.nextInt(minValueOfRandom, maxValueOfRandom);
    }
    public static int makeAnyQuestionNumber() {
        var maxValueOfRandom = 100;
        Random random = new Random();
        return random.nextInt(maxValueOfRandom);
    }
    public static String makeGameQuestion(int firstQuestionNumber, int secondQuestionNumber, Character mathCharacter) {
        return "Question: " + firstQuestionNumber + " " + mathCharacter + " " + secondQuestionNumber;
    }
    public static void game(int countOfAttempts) {
        String[] questions = new String[countOfAttempts];
        int[] correctAnswers = new int[countOfAttempts];
        var firstQuestion = answerBranch();
        for (var i = 0; i < countOfAttempts; i++) {
            var firstGameNumber = makeAnyQuestionNumber();
            var secondGameNumber = makeAnyQuestionNumber();
            var mathVariant = makeMathVariant();
            var mathChar = makeCharacterForThisMathOperation(mathVariant);
            questions[i] = makeGameQuestion(firstGameNumber, secondGameNumber, mathChar);
            correctAnswers[i] = resultForOperation(firstGameNumber, secondGameNumber, mathVariant);
        }
        Engine.playGame(countOfAttempts, questions, correctAnswers, firstQuestion);
    }
}

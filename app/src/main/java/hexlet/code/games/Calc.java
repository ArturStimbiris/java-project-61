package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Calc {
    //Set choice options
    public static final int CHOICE_ONE = 1;
    public static final int CHOICE_TWO = 2;
    public static final int CHOICE_THREE = 3;
    public static final int MAX_VALUE_OF_RANDOM = 100;
    public static final int MIN_VAL_OPERATOR = 1;
    public static final int MAX_VAL_OPERATOR = 4;
    public static String answerBranch() {
        return "What is the result of the expression?";
    }
    public static int resultForOperation(int numberOne, int numberTwo, int mathVariant) {
        switch (mathVariant) {
            case CHOICE_ONE:
                return numberOne + numberTwo;
            case CHOICE_TWO:
                return numberOne - numberTwo;
            case CHOICE_THREE:
                return numberOne * numberTwo;
            default:
                return 0;
        }
    }
    public static Character makeCharacterForThisMathOperation(int mathVariant) {
        switch (mathVariant) {
            case CHOICE_ONE:
                return '+';
            case CHOICE_TWO:
                return '-';
            case CHOICE_THREE:
                return '*';
            default:
                return null;
        }
    }
    public static int makeMathVariant() {
        Random random = new Random();
        return random.nextInt(MIN_VAL_OPERATOR, MAX_VAL_OPERATOR);
    }
    public static int makeAnyQuestionNumber() {
        Random random = new Random();
        return random.nextInt(MAX_VALUE_OF_RANDOM);
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

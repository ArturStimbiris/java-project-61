package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Calc {
    public static final int CHOICE_ONE = 1;
    public static final int CHOICE_TWO = 2;
    public static final int CHOICE_THREE = 3;
    public static final int MAX_VALUE_OF_RANDOM = 100;
    public static final int MIN_VAL_OPERATOR = 1;
    public static final int MAX_VAL_OPERATOR = 4;
    public static final String RULES = "What is the result of the expression?";
    public static int result(int numberOne, int numberTwo, int mathVariant) {
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
    public static Character makeChar(int mathVariant) {
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
    public static String makeQuestion(int firstNumber, int secondNumber, Character mathCharacter) {
        return "Question: " + firstNumber + " " + mathCharacter + " " + secondNumber;
    }
    public static void game() {
        String[] qa = new String[Engine.COUNT_OF_ATTEMPTS];
        for (var i = 0; i < Engine.COUNT_OF_ATTEMPTS; i++) {
            var numOne = makeAnyQuestionNumber();
            var numTwo = makeAnyQuestionNumber();
            var mathVariant = makeMathVariant();
            var mathChar = makeChar(mathVariant);
            qa[i] = makeQuestion(numOne, numTwo, mathChar) + ", " + result(numOne, numTwo, mathVariant);
        }
        Engine.playGame(qa, RULES);
    }
}

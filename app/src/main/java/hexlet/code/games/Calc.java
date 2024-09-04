package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final int CHOICE_ONE = 1;
    private static final int CHOICE_TWO = 2;
    private static final int CHOICE_THREE = 3;
    private static final int MAX_VALUE_OF_RANDOM = 100;
    private static final int MIN_VAL_OPERATOR = 1;
    private static final int MAX_VAL_OPERATOR = 4;
    private static final String RULES = "What is the result of the expression?";
    private static Character mathChar = null;

    public static int result(int numberOne, int numberTwo, int mathVariant) {
        switch (mathVariant) {
            case CHOICE_ONE:
                mathChar = '+';
                return numberOne + numberTwo;
            case CHOICE_TWO:
                mathChar = '-';
                return numberOne - numberTwo;
            case CHOICE_THREE:
                mathChar = '*';
                return numberOne * numberTwo;
            default:
                throw new Error("Unknown number");
        }
    }

    public static String makeQuestion(int firstNumber, int secondNumber, Character mathCharacter) {
        return "Question: " + firstNumber + " " + mathCharacter + " " + secondNumber;
    }

    public static void game() {
        String[] qa = new String[Engine.COUNT_OF_ATTEMPTS];
        for (var i = 0; i < Engine.COUNT_OF_ATTEMPTS; i++) {
            var numOne = Utils.getRandomNum(MAX_VALUE_OF_RANDOM);
            var numTwo = Utils.getRandomNum(MAX_VALUE_OF_RANDOM);
            var mathVar = Utils.getRandomNum(MIN_VAL_OPERATOR, MAX_VAL_OPERATOR);
            var mathResult = result(numOne, numTwo, mathVar);
            qa[i] = makeQuestion(numOne, numTwo, mathChar) + ", " + mathResult;
        }
        Engine.playGame(qa, RULES);
    }
}

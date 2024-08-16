package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Calc {
    //Set choice options
    public static final int choiceOne = 1;
    public static final int choiceTwo = 2;
    public static final int choiceThree = 3;
    public static final int maxValueOfRandom = 100; //Make max value of random number for this game
    public static final int minValueOfRandomForOperator = 1; //Make min value of random number for generate math operator
    public static final int maxValueOfRandomForOperator = 4; //Make max value of random number for generate math operator
    public static String answerBranch() {
        return "What is the result of the expression?";
    }
    public static int resultForOperation(int numberOne, int numberTwo, int mathVariant) {
        switch (mathVariant) {
            case choiceOne:
                return numberOne + numberTwo;
            case choiceTwo:
                return numberOne - numberTwo;
            case choiceThree:
                return numberOne * numberTwo;
            default:
                return 0;
        }
    }
    public static Character makeCharacterForThisMathOperation(int mathVariant) {
        switch (mathVariant) {
            case choiceOne:
                return '+';
            case choiceTwo:
                return '-';
            case choiceThree:
                return '*';
            default:
                return null;
        }
    }
    public static int makeMathVariant() {
        Random random = new Random();
        return random.nextInt(minValueOfRandomForOperator, maxValueOfRandomForOperator);
    }
    public static int makeAnyQuestionNumber() {
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

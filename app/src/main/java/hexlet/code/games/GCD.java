package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class GCD {
    public static String answerBranch() {
        return "Find the greatest common divisor of given numbers.";
    }
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
        var maxValueOfRandom = 100;
        Random random = new Random();
        return random.nextInt(maxValueOfRandom);
    }
    public static String makeGameQuestion(int firstQuestionNumber, int secondQuestionNumber) {
        return "Question: " + firstQuestionNumber + " " + secondQuestionNumber;
    }
    public static void game(int countOfAttempts) {
        String[] questions = new String[countOfAttempts];
        int[] correctAnswers = new int[countOfAttempts];
        var firstQuestion = answerBranch();
        for (var i = 0; i < countOfAttempts; i++) {
            var firstGameNumber = makeAnyQuestionNumber();
            var secondGameNumber = makeAnyQuestionNumber();
            questions[i] = makeGameQuestion(firstGameNumber, secondGameNumber);
            correctAnswers[i] = gcdForTwoNumbers(firstGameNumber, secondGameNumber);
        }
        Engine.playGame(countOfAttempts, questions, correctAnswers, firstQuestion);
    }
}


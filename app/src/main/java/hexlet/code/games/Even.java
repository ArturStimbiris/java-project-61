package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Even {
    public static final int maxValueOfRandom = 100; //Make max value of random number for this game (100)
    public static String answerBranch() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
    public static boolean isEven(int n) {
        if (n % 2 > 0) {
            return false;
        }
        return true;
    }
    public static int makeAnyQuestionNumber() {
        Random random = new Random();
        return random.nextInt(maxValueOfRandom);
    }
    public static String makeGameQuestion(int firstQuestionNumber) {
        return "Question: " + firstQuestionNumber;
    }
    public static void game(int countOfAttempts) {
        String[] questions = new String[countOfAttempts];
        String[] correctAnswers = new String[countOfAttempts];
        var firstQuestion = answerBranch();
        for (var i = 0; i < countOfAttempts; i++) {
            var firstGameNumber = makeAnyQuestionNumber();
            questions[i] = makeGameQuestion(firstGameNumber);
            var isEvenNumber = isEven(firstGameNumber);
            if (isEvenNumber) {
                correctAnswers[i] = "yes";
            } else {
                correctAnswers[i] = "no";
            }
        }
        Engine.playGame(countOfAttempts, questions, correctAnswers, firstQuestion);
    }
}

package hexlet.code;
import java.util.Random;

public class Utils {
    private static Random random = new Random();

    public static int getRandomNum(int numOne) {
        return random.nextInt(numOne);
    }

    public static int getRandomNum(int numOne, int numTwo) {
        return random.nextInt(numOne, numTwo);
    }
}

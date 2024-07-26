package hexlet.code;
import java.util.Scanner;

class Greeting {
    public String userName;
    Greeting(String userName) {
        this.userName = userName;
    }

    public void setUserName(String userName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        this.userName = scanner.next();
        scanner.close();
    }
    public void greet() {
        System.out.println("Hello, " + userName + "!");
    }
}

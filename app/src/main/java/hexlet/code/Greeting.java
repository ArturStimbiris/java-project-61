package hexlet.code;
import java.util.Scanner;

class Greeting {
    public String userName;
    public Scanner scanner;
    Greeting() {
        this.userName = "unknown";
        this.scanner = new Scanner(System.in);
    }
    public void welcome() {
        System.out.println("Welcome to the Brain Games!");
    }
    public void setUserName() {
        System.out.print("May I have your name? ");
        try {
            this.userName = scanner.next();
        }
        catch (Exception e) {
            this.userName = "unknown";
        }
    }
    public void greet() {
        System.out.println("Hello, " + userName + "!");
    }
    public void greeting() {
        this.welcome();
        this.setUserName();
        this.greet();
    }
    public String getUserName() {
        return userName;
    }
}

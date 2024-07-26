package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        String user = "unknown";
        var greeting = new Greeting(user);
        greeting.setUserName(user);
        greeting.greet();
    }
}
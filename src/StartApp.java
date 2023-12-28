import java.util.Scanner;

public class StartApp {
    public static void main(String[] args) {
        System.out.println("""
                Welcome in my Cryptoanalyzer!
                You can choose the operating mode:
                Write 1, if you want to use text encryption
                Write 2, if you want to use text decryption
                Write 3, if you want to use Brute force""");
        int choose = new Scanner(System.in).nextInt();
        switch (choose) {
            case 1 -> {
                System.out.println("You choose text encryption");
            }
            case 2 -> {
                System.out.println("You choose text decryption");
            }
            case 3 -> {
                System.out.println("You choose Brute force");
            }
            default -> {
                System.out.println("You choose something wrong!");
            }
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n % 2 == 1) { //홀수이면
            System.out.println("SK");
        } else { //짝수이면
            System.out.println("CY");
        }
    }
}

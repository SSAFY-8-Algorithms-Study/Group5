import java.util.Scanner;

public class Main {
    static int x, y;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        y = scan.nextInt();
        if (x > y) {
            System.out.println(x + y + y / 10);
        } else {
            System.out.println(x + y + x / 10);
        }
    }
}

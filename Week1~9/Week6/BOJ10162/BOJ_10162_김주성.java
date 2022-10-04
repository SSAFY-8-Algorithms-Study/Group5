import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[3];
        if (T % 10 != 0) {
            System.out.println(-1);
        } else {
            int d = T / 300;
            T %= 300;
            result[0] = d;

            d = T / 60;
            T %= 60;
            result[1] = d;

            d = T / 10;
            result[2] = d;

            for (int i = 0; i < 3; i++) {
                System.out.print(result[i] + " ");
            }
        }
    }
}

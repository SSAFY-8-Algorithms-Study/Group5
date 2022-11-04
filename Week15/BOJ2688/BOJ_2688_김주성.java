import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] memo;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        memo = new long[65][10];
        for (int num = 0; num < 10; num++) memo[1][num] = 1;
        for (int i = 2; i <= 64; i++) memo[i][0] = 1;

        for (int i = 1; i <= 64; i++) {
            for (int num = 1; num < 10; num++) memo[i][num] += memo[i-1][num] + memo[i][num - 1];
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(memo[n][9]).append('\n');
        }
        System.out.print(sb.toString());
    }
}

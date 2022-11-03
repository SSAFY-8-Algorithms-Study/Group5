import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int X, Y;
    static long W, S, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        W = Long.parseLong(st.nextToken()); // 가로/세로
        S = Long.parseLong(st.nextToken()); // 대각선

        // 1. 가로/세로 (1,0),(0,1) 방향으로 이동
        long a = (X + Y) * W;

        // 2. 대각선 (1,1),(-1,1),(1,-1) 방향으로 이동(격자만 가능)
        long b = Long.MAX_VALUE;
        if ((X % 2 == 0 && Y % 2 == 0) || (X % 2 == 1 && Y % 2 == 1)) {
            b = Math.min(X, Y) * S + Math.abs(X - Y) * S;
        }

        // 3. 최대한 대각선(1,1)로 이동한 후 가로(0,1)/세로(1,0) 방향으로 이동
        long c = Long.MAX_VALUE;
        if (S < W) { // 대각선 이동이 가로/세로 이동보다 비용이 적으면
            // 도착점 -1 까지 대각선 이동
            c = Math.min(X, Y) * S + (Math.abs(X - Y) - 1) * S + W;
        } else {
            c = Math.min(X, Y) * S + Math.abs(X - Y) * W;
        }

        ans = Math.min(a, b);
        ans = Math.min(ans, c);
        System.out.println(ans);
    }
}

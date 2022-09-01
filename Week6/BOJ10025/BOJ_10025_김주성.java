import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] A;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken()); // 얼음의 양
            A[i][1] = Integer.parseInt(st.nextToken()); // 좌표
        }
    }

    static void pro() {
        Arrays.sort(A, Comparator.comparingInt(o1 -> o1[1]));
        int R = 0, sum = 0, ans = 0;
        for (int L = 1; L <= N; L++) {
            // L-1 구간 제외
            sum -= A[L-1][0];

            // R을 옮길 수 있을 때 까지 옮기기
            while(R + 1 <= N && A[R + 1][1] - A[L][1] <= K * 2) {
                R++;
                sum += A[R][0];
            }

            // [ L ... R ]합 sum이 조건을 만족하면 정답 갱신하기
            if (A[R][1] - A[L][1] <= K * 2) {
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}

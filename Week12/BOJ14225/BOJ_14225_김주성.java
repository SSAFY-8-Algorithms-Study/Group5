import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[] A;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        visit = new boolean[2000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void rec_func(int k, int sum) {
        if (k == N) {
            visit[sum] = true;
            return;
        }
        rec_func(k + 1, sum + A[k]);
        rec_func(k + 1, sum);
    }

    static void pro() {
        rec_func(0, 0);

        for (int i = 1; i < 2000001; i++) {
            if (!visit[i]) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}

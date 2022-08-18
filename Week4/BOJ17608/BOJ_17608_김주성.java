import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17608_김주성 {
    static int N, ans;
    static int[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void pro() {
        int max = Integer.MIN_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            if(arr[i] > max) { // 가장 큰 막대기 보다 크면
                max = arr[i];
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
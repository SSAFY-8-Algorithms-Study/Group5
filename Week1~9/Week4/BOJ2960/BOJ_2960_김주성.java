import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960_김주성 {
    static int N, K, count, ans;
    static boolean[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static void calculation(boolean[] arr, int n) {
        for (int i = n; i < arr.length; i += n) {
            if (arr[i]) { // i가 베열에 존재하면
                count++;
                if (count == K) ans = i;
                arr[i] = false; // i를 베열에 존재하면
            }
        }
    }

    static void pro() {
        arr = new boolean[N + 1];
        for (int i = 2; i <= N; i++) { // 2 부터 N 까지 초기화
            arr[i] = true;
        }
        for (int i = 2; i <= N; i++) {
            if (arr[i]){
                calculation(arr, i); // i와 i의 배수 삭제
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
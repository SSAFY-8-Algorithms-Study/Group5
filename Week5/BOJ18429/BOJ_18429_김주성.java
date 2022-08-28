import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_김주성 {
    static int N, K, ans;
    static int[] nums, days;
    static boolean[] select;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        days = new int[N + 1];
        select = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static boolean calculation(int[] days) {
        int weight = 500;
        for (int i = 1; i <= N; i++) {
            weight += days[i];
            weight -= K;
            if (weight < 500) {
                return false;
            }
        }
        return true;
    }

    static void rec_func(int k) {
        if (k == N + 1) {
            if(calculation(days)) {
                ans++;
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(select[i]) continue;
            select[i] = true;
            days[k] = nums[i];
            rec_func(k + 1);
            select[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        System.out.println(ans);
    }
}

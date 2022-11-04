import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, k, ans1, ans2;
    static String text;

    static void pro(char op) {
        int R = 0, op_sum = 0, len = 0;

        // 0부터 시작
        if (text.charAt(0) == op) op_sum++;
        len++;

        for (int L = 0; L < text.length(); L++) {
            // L - 1구간 제외
            if ((L - 1) >= 0 && text.charAt(L - 1) == op) op_sum--;
            if ((L - 1) >= 0) len--;

            // 가능한 끝까지 R 옮기기
            while (R + 1 < text.length() && op_sum < k) {
                R++;
                len++;
                if (text.charAt(R) == op) op_sum++;
            }

            // 정답 갱신
            if (op_sum == k) {
                ans1 = Math.min(ans1, len);
                if (text.charAt(L) == op && text.charAt(R) == op)
                    ans2 = Math.max(ans2, len);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            ans1 = Integer.MAX_VALUE; // 3번 답
            ans2 = Integer.MIN_VALUE; // 4번 답
            text = br.readLine();
            k  = Integer.parseInt(br.readLine());
            for (int i = 0; i < 26; i++) {
                pro((char)('a' + i));
            }
            if (ans1 == Integer.MAX_VALUE || ans2 == Integer.MIN_VALUE) {
                sb.append(-1).append('\n');
            } else {
                sb.append(ans1).append(' ').append(ans2).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}

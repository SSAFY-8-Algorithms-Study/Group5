import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, ans;
    static int[] A, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[27];
        String first = br.readLine();
        for (int i = 0; i < first.length(); i++) A[first.charAt(i) - 'A']++;

        for (int i = 1; i < N; i++) {
            String compare = br.readLine();
            // 가지치기: 비교하려는 문자열의 길이와 처음 문자열의 갈이 차이가 2 이상일때
            if (Math.abs(first.length() - compare.length()) > 1) continue;
            C = new int[27];
            for (int j = 0; j < compare.length(); j++) C[compare.charAt(j) - 'A']++;
            int cnt = 0;
            boolean isChanged = false;
            for (int j = 0; j < 27; j++) {
                if (A[j] == C[j]) continue;

                if (first.length() == compare.length()) { // 문자 변경하기
                    cnt += Math.abs(A[j] - C[j]);
                    isChanged = true;
                } else { // 문자 더하기 혹은 빼기
                    cnt += Math.abs(A[j] - C[j]);
                }
            }

            if(cnt <= 1 || (isChanged && cnt == 2)) ans++;
        }

        System.out.println(ans);
    }
}

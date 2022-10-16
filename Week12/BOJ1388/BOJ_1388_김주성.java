import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static int N, M, ans;
   static char[][] A;

   static void input() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      A = new char[N][];
      for (int i = 0; i < N; i++) A[i] = br.readLine().toCharArray();
   }

   static void pro() {
      //가로
      for (int i = 0; i < N; i++) {
         int cnt = 0;
         for (int j = 0; j < M; j++) {
            if (A[i][j] == '-') cnt++;
            if (A[i][j] == '|') {
               if (cnt > 0) ans++;
               cnt = 0;
            }
         }
         if (cnt > 0) ans++;
      }

      //세로
      for (int j = 0; j < M; j++) {
         int cnt = 0;
         for (int i = 0; i < N; i++) {
            if (A[i][j] == '|') cnt++;
            if (A[i][j] == '-') {
               if (cnt > 0) ans++;
               cnt = 0;
            }
         }
         if (cnt > 0) ans++;
      }

      System.out.println(ans);
   }

   public static void main(String[] args) throws IOException {
      input();
      pro();
   }

}

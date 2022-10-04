import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_김주성 {
    public static void main(String[] args) throws IOException {
        int[][] board = new int[101][101]; // 흰색 도화지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t = 0; t < n; t++){ // 색종이 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int i = a; i < a + 10; i++){ //색종이 넓이만큼 도와지에 1넣기
                for(int j = b; j < b + 10; j++){
                    board[i][j] = 1;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < 101; i++){ //도화지에 1의 개수만큼 더하기
            for(int j = 0; j < 101; j++){
                if(board[i][j] == 1){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}

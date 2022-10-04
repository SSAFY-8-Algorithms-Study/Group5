import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        int max = Math.max(N, M);
        for(int i = 0; i < N; i++){
            String row = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(row.charAt(j)+"");
            }
        }
        int size = 1;
        for(int n = 1; n < max; n++){
            for(int i = 0; i + n < N; i++){
                for(int j = 0; j + n < M; j++){
                    if(i + n < N && j + n < M){
                        if(board[i][j+n] - board[i][j] == 0 &&
                                board[i+n][j+n] - board[i+n][j] == 0 &&
                                board[i][j] - board[i+n][j+n] == 0){
                            size = (n + 1) * (n + 1);
                        }
                    }
                }
            }
        }
        System.out.println(size);
    }
}

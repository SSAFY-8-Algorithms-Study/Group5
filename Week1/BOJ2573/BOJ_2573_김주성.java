import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] icebreg;
    static int[] nx = {0, 0, -1, 1};
    static int[] ny = {-1, 1, 0, 0};
    static boolean[][] visit;
    static int[][] melt;


    public static void melts_icebreg(){
        for(int x = 0; x < N; x++){
            for(int y = 0; y < M; y++){
                if(icebreg[x][y] != 0){
                    if(icebreg[x][y] - melt[x][y] <= 0){
                        icebreg[x][y] = 0;
                    }else{
                        icebreg[x][y] -= melt[x][y];
                    }
                }
            }
        }
    }

    public static int calcu_set(){
        visit = new boolean[N][M];
        int count = 0;
        for(int x = 0; x < N; x++){
            for(int y = 0; y < M; y++){
                if(icebreg[x][y] != 0 && !visit[x][y]){
                    dfs(x, y);
                    count++;
                }
            }
        }
        return count;
    }

    public static void calcu_melts(){
        melt = new int[N][M];
        for(int x = 0; x < N; x++){
            for(int y = 0; y < M; y++){
                if(icebreg[x][y] != 0){
                    int count = 0;
                    for(int i = 0; i < 4; i++){
                        int next_x = x + nx[i];
                        int next_y = y + ny[i];
                        if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < M){
                            if(icebreg[next_x][next_y] == 0){
                                count++;
                            }
                        }
                    }
                    melt[x][y] = count;
                }
            }
        }
    }
    public static void dfs(int x, int y){
        visit[x][y] = true;
        for(int i = 0; i < 4; i++){
            int next_x = x + nx[i];
            int next_y = y + ny[i];
            if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < M){
                if(icebreg[next_x][next_y] != 0 && !visit[next_x][next_y]){
                    dfs(next_x, next_y);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        icebreg = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                icebreg[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean isSetOne = true;
        int year = 0;
        while(isSetOne){
            //STEP1: 빙산 녹는 정도 탐색
            calcu_melts();
            //STEP2: 빙산 녹이기
            melts_icebreg();
            //STEP3: 빙산 집합 계산
            int set = calcu_set();
            if(set > 1){
                isSetOne = false;
            }else if(set == 0){
                year = 0;
                break;
            }
            year++;
        }
        System.out.println(year);
    }
}

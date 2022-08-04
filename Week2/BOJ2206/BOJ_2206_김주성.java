import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_김주성 {
    static int[][] board;
    static int[][] visit;
    static int N, M, count=Integer.MAX_VALUE, endX, endY;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Dot{
        int x;
        int y;
        int move; // 이동 거리
        int wall; // 벽믈 부수면 1 부수지 않았으면 0

        public Dot(int x, int y, int move, int wall){
            this.x = x;
            this.y = y;
            this.move = move;
            this.wall = wall;
        }
    }

    static void bfs(){
        if(endX== 0 && endY == 0){//시작이 끝이면
            count = 1;
            return;
        }
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(0, 0, 1, 0));//시작점
        visit[0][0] = 2;//시작은 방문
        //0: 방문 가능, 1: 벽을 부순 점은 방분 불가능, 2: 방문 불가능
        while(!queue.isEmpty()){
            Dot dot = queue.poll();
            if(dot.x == endX && dot.y == endY){//도착점에 도착하면
                count = Math.min(count, dot.move);//가장 이동 횟수가 적은 것을 저장
                continue;
            }
            for(int i = 0; i < 4; i++){
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];
                if(nextX >= 0 && nextX < N && nextY >=0 && nextY < M && visit[nextX][nextY] < 2){
                    //방문이 가능한 점이면
                    //3가지 상태에 대해서 검사해야함.
                    if(board[nextX][nextY] == 0 && dot.wall == 0) { // 상태1: 벽을 부신 적이 없음
                        visit[nextX][nextY] = 2; // 다시 방문 할 수 없음
                        queue.add(new Dot(nextX, nextY, dot.move + 1, dot.wall));
                    }else if(board[nextX][nextY] == 0 && dot.wall == 1 && visit[nextX][nextY] == 0){ //상태2: 벽을 부신 적이 있음
                        visit[nextX][nextY] = 1; // 일부는 다시 방문 가능
                        queue.add(new Dot(nextX, nextY, dot.move + 1, dot.wall));
                    }else if(board[nextX][nextY] == 1 && dot.wall == 0){ //상태3: 벽을 부심
                        visit[nextX][nextY] = 2; // 다시 방문 할 수 없음
                        queue.add(new Dot(nextX, nextY, dot.move + 1, dot.wall + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];//맵
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = line.charAt(j)-'0';
            }
        }//end input
        visit = new int[N][M];
        endX = N - 1; //도착 위치
        endY = M - 1;
        bfs();
        if(count == Integer.MAX_VALUE){//초기값과 같으면
            System.out.println(-1);
        }else{
            System.out.println(count);
        }
    }
}

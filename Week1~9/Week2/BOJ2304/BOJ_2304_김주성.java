import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2304_김주성 {
    static class Polygon implements Comparable<Polygon>{
        //다각형 객체
        int x;
        int y;

        public Polygon(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Polygon o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] roof = new int[1001][1001]; // 2차원 배열로 지붕 선언
        List<Polygon> list = new ArrayList<>();
        Polygon highestPolygon = new Polygon(0, 0);
        for(int t = 0; t < N; t++){ // 다각형 개수만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Polygon polygon = new Polygon(x, y); //다각형 생성
            if(polygon.y > highestPolygon.y){ //가장 높은 다각혈 찾기
                highestPolygon = polygon;
            }
            list.add(polygon);
        }// end input
        Collections.sort(list); //x축 기준으로 정렬
        for(Polygon polygon : list){ // 반복문 1: 처음 부터 가장 높은 다각형 까지 반복
            if(polygon == highestPolygon){ // 가장 높은 다각형을 만나면 반복문 종료
                break;
            }
            for(int i = polygon.x; i < highestPolygon.x; i++){
                for(int j = 1; j <= polygon.y; j++){ // 가장 높은 다각형을 만날 때 까지 계속 1입력
                    roof[i][j] = 1;
                }
            }
        }
        for(int j = 1; j <= highestPolygon.y; j++){// 가장 높은 다각형
            roof[highestPolygon.x][j] = 1;
        }
        for(int k = list.size()-1; k >=0; k--){ // 반복문 2: 마지막 다각형 부터 가장 높은 다각형 까지 반복
            Polygon polygon = list.get(k);
            if(polygon == highestPolygon){ // 가장 높은 다각형을 만나면 반복문 종료
                break;
            }
            for(int i = polygon.x; i > highestPolygon.x; i--){
                for(int j = 1; j <= polygon.y; j++){ // 가장 높은 다각형을 만날 때 까지 계속 1입력
                    roof[i][j] = 1;
                }
            }
        }
        int sum = 0;
        for(int i = 1; i < 1001; i++){// 지붕 넓이 계산
            for(int j = 1; j < 1001; j++){
                if(roof[i][j] == 1){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}

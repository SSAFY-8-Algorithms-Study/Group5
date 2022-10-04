import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1931_김주성 {
    static class Meeting implements Comparable<Meeting>{
        //회의 정보
        int start;
        int end;

        public Meeting(int strat, int end){
            this.start = strat;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            //정렬 기준: 회의 끝나는 시간 -> 회의 시작 시간 우선 순위로 오름차순으로 정렬
            if(this.end != o.end){
                return this.end - o.end;
            }else{
                return this.start - o.start;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetingList = new LinkedList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            meetingList.add(new Meeting(startTime, endTime));
        }//end input
        Collections.sort(meetingList);// 정렬 기준에 따라 희의 정렬
        int count = 0;
        Meeting prev = new Meeting(0 ,0);//시작 회의
        for(Meeting meeting : meetingList){
            //가장 빨리 끝나는 회의 선택
            if(prev.end <= meeting.start){//이번 회의의 시작 시간이 이전의 회의의 끝나는 시간 이후이면
                prev = meeting;
                count++;
            }
        }
        System.out.println(count);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2]; //시작시간, 끝나는 시간 저장
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			arr[i][0] = Integer.parseInt(st.nextToken()); //시작 시간
			arr[i][1] = Integer.parseInt(st.nextToken()); //끝나는 시간
		}
		
		//끝나는 시간 오름차순 정렬 -> 시작 시간 오름차순 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) { //끝나는 시간이 같으면
					return o1[0] - o2[0]; //시작 시간 오름 차순
				}else {
					return o1[1] - o2[1]; //끝나는 시간 오름 차순
				}	
			}
		});

		int count = 0;
		int end = 0; //끝나는 시간이 기준
		for(int i = 0; i < N; i++) {
			if(arr[i][0] >= end) {
				count++;
				end = arr[i][1];
			}
		}
		
		System.out.println(count);
	}

}

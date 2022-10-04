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
		
		int[][] arr = new int[N][2];
		
		int max = 0;
		int idx = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			arr[i][0] = L;
			arr[i][1] = H;
		}
		
		//구현
		Arrays.sort(arr, new Comparator<int[]>() { //l 기준 오름차순 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		//최고점 구하기
		for(int i = 0; i < N; i++) {
			if(arr[i][1] > max) {
				max = arr[i][1];
				idx = i;
			}
		}
		
		int area = max; //가운데 면적
		
		//왼쪽 면적
		int left_max = 0;
		int left_idx = 0;
		for(int i = 0; i <= idx; i++) {
			if(arr[i][1] >= left_max) {
				area += left_max * (arr[i][0] - arr[left_idx][0]); //이전 최고 높이*이전 좌표
				//갱신
				left_max = arr[i][1];
				left_idx = i;
			}
		}
		
		//오른쪽 면적
		int right_max = 0;
		int right_idx = N - 1;
		for(int i = N - 1; i >= idx; i--) {
			if(arr[i][1] >= right_max) {
				area += right_max * (arr[right_idx][0] - arr[i][0]); //이전 최고 높이*이전 좌표
				//갱신
				right_max = arr[i][1];
				right_idx = i;
			}
		}
		
		//출력
		System.out.println(area);
	}

}

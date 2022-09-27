import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_김아린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		//구현
		Arrays.sort(tree); //이분 탐색을 위한 정렬
		
		int answer = 0;
		int low = 0; //H 최소
		int high = tree[tree.length - 1]; //H 최대(가장 큰 나무)
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			long sum = 0;
			for(int i = 0; i < N; i++) {
				if(tree[i] > mid) { //절단하고 남으면
					sum += (tree[i] - mid); //들고 가기
				}
			}
			
			if(sum < M) { //M보다 더 적은 나무 가져가면
        		high = mid - 1; //H 줄이기
        	} else { //M보다 더 많은 나무 가져가면
        		low = mid + 1; //H 늘리기
        		answer = mid;
        	}
		}
		
		//출력
		System.out.println(answer);
	}

}

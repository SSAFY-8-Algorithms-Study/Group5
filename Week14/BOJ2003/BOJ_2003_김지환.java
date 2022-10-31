import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 포인터 left,right
		int left = 0;
		int right = 0;

		// 수들의 합을 알아보기 위한 sum 변수
		int sum = arr[left];

		// 수들의 합이 M을 만족한다면 카운트를 세기 위한 변수
		int cnt = 0;
		// left가 arr.length보다 크거나 같으면 하나의 배열의 요소 끝까지 돌았으므로 그 때 종료하게 된다.
		while (left < arr.length || right < arr.length) {
			if(sum == M ) {
				cnt++;
				left = left+1;
				if(left == arr.length) break;
				right = left;
				sum = arr[left];
				if(sum == M) {
					cnt++;
					left = left+1;
					if(left == arr.length) break;
					right = left;
					sum = arr[left];
				}
			}if(sum > M) {
				left = left+1;
				if(left >= arr.length) break;
				right = left;
				sum = arr[left];
				if(sum == M) {
					cnt++;
					left = left+1;
					if(left >=arr.length) break;
					right =left;
					sum = arr[left];
				}
			}
				right++;
				if(right >= arr.length)break;
				sum += arr[right];
		}
		System.out.println(cnt);
		
	}

}

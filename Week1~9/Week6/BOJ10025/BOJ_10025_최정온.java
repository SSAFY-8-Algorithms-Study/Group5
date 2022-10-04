package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10025_최정온 {
	// 얼음 양동이의 수
	static int N;

	// 엘버트가 좌우로 닿는 거리
	static int K;

	static int[] list = new int[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		for (int index = 0; index < N; index++) {
			// 얼음의 양
			int g = sc.nextInt();

			// 얼음의 좌표
			int x = sc.nextInt();

			list[x] = g;
		}
		
		int range = K*2+1;
		
//		System.out.println(Arrays.toString(list));
		System.out.println(maxSum(list, list.length, range));
	}
	
    static int maxSum(int arr[], int n, int k)
    {
    	int max_sum = 0;
        if (n < k) {
        	for (int i = 0; i < n; i++) {
        		max_sum += arr[i];
        	}
            return max_sum;
        } else {
        	for (int i = 0; i < k; i++) {
        		max_sum += arr[i];
        	}
        	
        	int window_sum = max_sum;
        	for (int i = k; i < n; i++) {
        		window_sum += arr[i] - arr[i - k];
        		max_sum = Math.max(max_sum, window_sum);
        	}
        	
        	return max_sum;
        }
    }
}

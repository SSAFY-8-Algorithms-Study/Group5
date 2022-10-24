package day1024;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2607 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		//int[] alpha = new int[26];
		int res = 0;
		int cnt = 0;
		int s = arr[0].length();
		for (int i = 1; i < N; i++) {
			if(Math.abs(arr[i].length()-s) >=2) {
				continue;
			}
			int[] alpha = new int[26];
			for (int j = 0; j < arr[0].length(); j++) {
				int temp = arr[0].charAt(j)-'A';
				alpha[temp]++;
			}
			//System.out.println(Arrays.toString(alpha));
			for (int j = 0; j < arr[i].length(); j++) {
				int temp = arr[i].charAt(j)-'A';
				alpha[temp]--;
			}
			
			//System.out.println(Arrays.toString(alpha));
		
			cnt = 0;
			boolean check = false;
			for (int j = 0; j <alpha.length; j++) {
				if(alpha[j] ==1 || alpha[j] == -1) {
					cnt++;
				}
				if(alpha[j] >1 || alpha[j] <-1) {
					check = true;
				}
			}
			
			if(!check && cnt<=2) {
				res++;
			}

		}
		
		System.out.println(res);

	}
}
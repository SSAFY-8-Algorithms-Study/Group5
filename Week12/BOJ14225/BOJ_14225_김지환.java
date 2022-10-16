import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] input;
	static boolean[] isSelect;
	static int N;
	static int[] numbers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		input = new int[N];
		isSelect = new boolean[N];
		numbers = new int[2000001];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		powerset(0, 0);
		
		int min = 0;
		for(int i=1; i<=2000000; i++) {
			if(numbers[i]==0) {
				min = i;
				break;
			}
		}
		System.out.println(min);

	}

	private static void powerset(int depth, int sum) {
		if (depth == N) {
			numbers[sum]++;
			return;
		}
		isSelect[depth] = true;
		powerset(depth + 1, sum + input[depth]);
		isSelect[depth] = false;
		powerset(depth+1,sum);
	}

}

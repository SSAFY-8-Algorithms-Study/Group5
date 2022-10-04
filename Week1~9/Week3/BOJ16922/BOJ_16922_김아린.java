import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] romeNum = {1, 5, 10, 50};
	static int[] result;
	static List<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		result = new int[N];
		list = new ArrayList<>();

		comb(0, 0);
		
		System.out.println(list.size());
	}

	public static void comb(int start, int depth) {
		if(depth == N) {
			int sum = 0;
			for(int n : result) {
				sum += n;
			}
			
			if(!list.contains(sum)) {
				list.add(sum);
			}
			
			return;
		}
		
		for(int i = start; i < romeNum.length; i++) {
			result[depth] = romeNum[i];
			comb(i, depth + 1);
		}
	}
}

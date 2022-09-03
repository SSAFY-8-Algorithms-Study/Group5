package silver;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_9372 {
	static int N;
	static int E;
	
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			E = sc.nextInt();
			
			list = new ArrayList[N+1];
			
			for (int i = 0; i <= N; i++) {
				list[i] = new ArrayList();
			}
			
			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				list[from].add(to);
				list[to].add(from);
			}
			
			System.out.println(N-1);
		}
	}
}

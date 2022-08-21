package day0820.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286_김지환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2))
					return 1;
				else if(Math.abs(o1) == Math.abs(o2)) 
					return o1-o2;
				else
					return -1;
				}
		});
		int N = Integer.parseInt(in.readLine());
		
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num == 0 && !q.isEmpty()) {
				sb.append(q.poll()).append("\n");
			}else if(num == 0 && q.isEmpty()) {
				sb.append(num).append("\n");
			}else {
				q.add(num);
			}
		}
		System.out.println(sb);
	}
}

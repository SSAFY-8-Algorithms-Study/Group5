package day0820.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ_17608_김지환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			stack.add(Integer.parseInt(in.readLine()));
		}
		int top = stack.pop();
		int current = 0;
		int cnt = 1;
		while(!stack.isEmpty()) {
			current = stack.pop();
			if(top < current) {
				top = current;
				cnt++;
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}

}

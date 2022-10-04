import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();

		int h = Integer.parseInt(br.readLine());
		stack.push(h);
		
		for(int i = 1; i < N; i++) {
			h = Integer.parseInt(br.readLine());
			
			while(true) {
				if(!stack.isEmpty() && h >= stack.peek()) {
					stack.pop();
				}else {
					stack.push(h);
					break;
				}
			}
			
		}
		
		System.out.println(stack.size());
	}

}

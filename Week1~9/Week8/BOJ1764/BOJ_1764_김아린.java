import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1764_김아린 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		HashSet<String> list = new HashSet<>();
		ArrayList<String> result = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String name = br.readLine();	
			list.add(name);
		}
		
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			
			if(list.contains(name)) {
				result.add(name);
			}
		}
		
		System.out.println(result.size());
		
		Collections.sort(result);
		for(String name : result) {
			System.out.println(name);
		}
	}

}

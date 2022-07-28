import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		for(int i = 0; i < 8; i++) {
			String row = br.readLine();
			
			for(int j = 0; j < 8; j++) {
				char ch = row.charAt(j);
				
				if(ch == 'F') {
					if(i % 2 == 0 && j % 2 == 0) {
						count++;
					} else if(i % 2 == 1 && j % 2 == 1) {
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
	}
	
}

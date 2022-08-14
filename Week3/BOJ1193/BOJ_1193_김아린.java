import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		
		int count =  1;
		int i = 1, j = 1;
		int c = 1; //↙, ↗ 반복 카운트
		
		while(true) {
			if(count == X) break;
			
			//→
			j++;
			count++;
			
			if(count == X) break;
			
			//↙
			for(int k = 0; k < c; k++) {
				i++;
				j--;
				count++;
				
				if(count == X) break;
			}
			if(count == X) break;
			c++;
			
			//↓
			i++;
			count++;
			
			if(count == X) break;
			
			//↗
			for(int k = 0; k < c; k++) {
				i--;
				j++;
				count++;
				
				if(count == X) break;
			}
			if(count == X) break;
			c++;
		}

		System.out.println(i + "/" + j);
	}

}

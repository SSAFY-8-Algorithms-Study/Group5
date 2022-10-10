import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(in.readLine());
		 int[][] map = new int[N][N];
		 
		 for(int i=0; i<N; i++) {
			 StringTokenizer st = new StringTokenizer(in.readLine());
			 for(int j=0; j<N; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 
		 for(int k=0;k<N;k++) {
			 for(int i=0; i<N; i++) {
				 for(int j=0;j<N;j++) {
					 if(map[i][k] == 1 && map[k][j] == 1) {
						 map[i][j] = 1;
					 }
				 }
			 }
		 }
		 
		 for(int i=0; i<N; i++) {
			 for(int j=0; j<N; j++) {
				 System.out.print(map[i][j]+" ");
			 }
			 System.out.println();
		 }
	}

}

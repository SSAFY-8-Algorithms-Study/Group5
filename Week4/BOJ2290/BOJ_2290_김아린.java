import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2290_김아린 {
	static char[][] monitor;
	static int height, width;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int s = Integer.parseInt(st.nextToken());
		String n = st.nextToken();
		
		height = 2 * s + 3;
		width =  s + 3; //가로는 공백 포함이라서 (s+2)+1
		
		monitor = new char[height][n.length() * width]; 
		
		//공백으로 초기화하기(안하면 기본값인 null이다)
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < n.length() * width; j++) {
				monitor[i][j] = ' ';
			}
		}
		
		//구현
		for(int k = 0; k < n.length(); k++) {
			char ch = n.charAt(k);
			
			switch(ch) {
			case '1' :
				printRightTop(k);
				printRightBottom(k);
				break;
			case '2' :
				printTop(k);
				printMiddle(k);
				printBottom(k);
				printRightTop(k);
				printLeftBottom(k);
				break;
			case '3' :
				printTop(k);
				printMiddle(k);
				printBottom(k);
				printRightTop(k);
				printRightBottom(k);
				break;
			case '4' :
				printMiddle(k);
				printLeftTop(k);
				printRightTop(k);
				printRightBottom(k);
				break;
			case '5' :
				printTop(k);
				printMiddle(k);
				printBottom(k);
				printLeftTop(k);
				printRightBottom(k);
				break;
			case '6' :
				printTop(k);
				printMiddle(k);
				printBottom(k);
				printLeftTop(k);
				printLeftBottom(k);
				printRightBottom(k);
				break;
			case '7' :
				printTop(k);
				printRightTop(k);
				printRightBottom(k);
				break;
			case '8' :
				printTop(k);
				printMiddle(k);
				printBottom(k);
				printLeftTop(k);
				printLeftBottom(k);
				printRightTop(k);
				printRightBottom(k);
				break;
			case '9' :
				printTop(k);
				printMiddle(k);
				printBottom(k);
				printLeftTop(k);
				printRightTop(k);
				printRightBottom(k);
				break;
			case '0' :
				printTop(k);
				printBottom(k);
				printLeftTop(k);
				printLeftBottom(k);
				printRightTop(k);
				printRightBottom(k);
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < n.length() * width; j++) {
				sb.append(monitor[i][j]);
			}
			
			if(i != height - 1) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);

	}

	public static void printRightTop(int k) {
		for(int i = 1; i < height / 2; i++) {
			monitor[i][(k + 1) * width - 2] = '|';
		}
		
	}
	
	public static void printRightBottom(int k) {
		for(int i = height / 2 + 1; i < height - 1; i++) {
			monitor[i][(k + 1) * width - 2] = '|';
		}
	}
	
	public static void printLeftTop(int k) {
		for(int i = 1; i < height / 2; i++) {
			monitor[i][k * width] = '|';
		}
	}
	
	public static void printLeftBottom(int k) {
		for(int i = height / 2 + 1; i < height - 1; i++) {
			monitor[i][k * width] = '|';
		}
	}
	
	public static void printTop(int k) {
		for(int i = k * width + 1; i < (k + 1) * width - 2; i++) {
			monitor[0][i] = '-';
		}
	}
	
	public static void printMiddle(int k) {
		for(int i = k * width + 1; i < (k + 1) * width - 2; i++) {
			monitor[height / 2][i] = '-';
		}
	}
	
	public static void printBottom(int k) {
		for(int i = k * width + 1; i < (k + 1) * width - 2; i++) {
			monitor[height - 1][i] = '-';
		}
	}

}

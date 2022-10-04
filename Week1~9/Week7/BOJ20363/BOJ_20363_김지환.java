package day0912;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_20363_김지환 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		int X = sc.nextInt();
//		int Y = sc.nextInt();
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int min = Math.min(X, Y);
		int answer = X+Y;
		int plus = min/10;
		answer+=plus;
		sb.append(answer);
		System.out.println(sb);
	}

}

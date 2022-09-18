package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 님 무기가 좀 나쁘시네요 
 * 크리와 파부는 요즘 새로 나온 이상한 게임을 하고 있다
 * 이 게임의 주요 특징 중 하나는 캐릭터의 전투력을 수치로 표현한다는 것인데 
 * 이를 통해 그 캐릭터가 얼마나 강한지를 대략적으로 파악할 수 있다. 
 * 게임 내에서 캐릭터는 무기를 단 하나 장착할 수 있는데
 * 어떤 무기를 창작하느냐에 따라 캐릭터의 전투력이 좋아질 수도 있고 나빠질 수도 있다 
 * 그러므로 사람들은 좋은 무기를 장착해서 전투력을 높히려고 한다. 
 * 어느 날 게임을 하던 크리와 파부는 신기한 일을 겪었다. 
 * 전투력 = (공격력) 
 * */
public class BOJ_11387_김지환 {
	
	static int[] cree;
	static int[] paboo;
	static int[] weapon1;
	static int[] weapon2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		cree = new int[5];
		paboo = new int[5];
		weapon1 = new int[5];
		weapon2 = new int[5];
		//크리와 피부의 전투력을 구하고 
		//3번째 이후부터는 무기를 장착을 한다. 기본적인 전투력과 무기의 장착력을 입력값을 받았을 때 전투력을 비교하면 된다. 
		//전투력을 담아야함. 
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<5;i++) {
				cree[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<5;i++) {
				paboo[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<5;i++) {
				weapon1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<5;i++) {
				weapon2[i] = Integer.parseInt(st.nextToken());
			}
		
			print();
	}

	private static void print() {
		double result1 = weapon(cree[0], cree[1], cree[2], cree[3], cree[4]); 
		double result2 = weapon(paboo[0], paboo[1], paboo[2], paboo[3], paboo[4]); 
		double result3 = weapon(cree[0]+weapon2[0]-weapon1[0], cree[1]+weapon2[1]-weapon1[1],cree[2]+weapon2[2]-weapon1[2],cree[3]+weapon2[3]-weapon1[3],cree[4]+weapon2[4]-weapon1[4]);
		double result4 = weapon(paboo[0]+weapon1[0]-weapon2[0], paboo[1]+weapon1[1]-weapon2[1],paboo[2]+weapon1[2]-weapon2[2],paboo[3]+weapon1[3]-weapon2[3],paboo[4]+weapon1[4]-weapon2[4]);
//		System.out.println(result1);
//		System.out.println(result2);
//		System.out.println(result3);
//		System.out.println(result4);
		if((int)result1==(int)result3) {
			System.out.println(0);
		}
		else if((int)result1> (int)result3) {
			System.out.println("-");
		}
		else if((int)result1 < (int)result3) {
			System.out.println("+");
		}
		if((int)result2==(int)result4) {
			System.out.println(0);
		}
		else if((int)result2> (int)result4) {
			System.out.println("-");
		}
		else if((int)result2 < (int)result4) {
			System.out.println("+");
		}
		
	}

	private static double weapon(double op0, double op1, double op2, double op3, double op4) {
		double power =  (op0) * (1.0+op1/100.0) * ((1.0-Math.min(op2/100.0, 1.0))+Math.min(op2/100, 1.0)*(op3/100.0))*(1.0+op4/100.0);
		return power;
	}

	

}

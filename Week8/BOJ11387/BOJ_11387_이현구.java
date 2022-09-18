package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11387 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Info> list = new ArrayList<>();
		int a, b, c, d, e;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			list.add(new Info(a, b, c, d, e));
		}
		Info cri = list.get(0);
		Info pabu = list.get(1);
		Info cri_w = list.get(2);
		Info pabu_w = list.get(3);
		list.add(new Info(cri.power-cri_w.power+pabu_w.power,
				cri.str-cri_w.str+pabu_w.str,
				cri.crit_per-cri_w.crit_per+pabu_w.crit_per,
				cri.crit_att_per-cri_w.crit_att_per+pabu_w.crit_att_per,
				cri.speed-cri_w.speed+pabu_w.speed));
		list.add(new Info(pabu.power-pabu_w.power+cri_w.power,
				pabu.str-pabu_w.str+cri_w.str,
				pabu.crit_per-pabu_w.crit_per+cri_w.crit_per,
				pabu.crit_att_per-pabu_w.crit_att_per+cri_w.crit_att_per,
				pabu.speed-pabu_w.speed+cri_w.speed));
		double totalPower_Cri = get_combatPower(cri);
		double totalPower_Pabu = get_combatPower(pabu);
		
		double change_Cri = get_combatPower(list.get(4));
		double change_Pabu = get_combatPower(list.get(5));
		
//		System.out.println(totalPower_Cri);
//		System.out.println(totalPower_Pabu);
//		System.out.println(change_Cri);
//		System.out.println(change_Pabu);
		
		if((long)(totalPower_Cri*1000) < (long)(change_Cri*1000))
			System.out.println("+");
		else if((long)(totalPower_Cri*1000) == (long)(change_Cri*1000))
			System.out.println("0");
		else
			System.out.println("-");
		
		if((long)(totalPower_Pabu*1000) < (long)(change_Pabu*1000))
			System.out.println("+");
		else if((long)(totalPower_Pabu*1000) == (long)(change_Pabu*1000))
			System.out.println("0");
		else
			System.out.println("-");
		
		
	}

	static public double get_combatPower(Info name) {
		double res1 = name.power * (1 + ((double) name.str / 100));
		double res2 = ((1 - Math.min(((double)name.crit_per / 100), 1))
				+ (Math.min(((double)name.crit_per / 100), 1) * ((double)name.crit_att_per / 100))) * (1 + ((double)name.speed / 100));
		return res1 * res2;
	}

	static class Info {
		int power;
		int str;
		int crit_per;
		int crit_att_per;
		int speed;

		public Info(int power, int str, int crit_per, int crit_att_per, int speed) {
			this.power = power;
			this.str = str;
			this.crit_per = crit_per;
			this.crit_att_per = crit_att_per;
			this.speed = speed;
		}
	}

}

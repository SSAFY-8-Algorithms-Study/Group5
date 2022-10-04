import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class BOJ_11387_김아린 {
		int attack, power, strikeP,strikeD, speed;

		public Skill(int attack, int power, int strikeP, int strikeD, int speed) {
			this.attack = attack;
			this.power = power;
			this.strikeP = strikeP;
			this.strikeD = strikeD;
			this.speed = speed;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Skill[] arr = new Skill[4]; //입력된 수치 저장 위한 배열
		
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int attack = Integer.parseInt(st.nextToken());
			int power = Integer.parseInt(st.nextToken());
			int strikeP = Integer.parseInt(st.nextToken());
			int strikeD = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			
			arr[i] = new Skill(attack, power, strikeP, strikeD, speed);
		}
		
		Skill armedK = arr[0]; //무기를 장착한 크리의 수치
		Skill armedP = arr[1]; //무기를 장착한 파부의 수치
		
		Skill weaponK = arr[2]; //크리가 현재 장착하고 있는 무기가 올려주는 수치
		Skill weaponP = arr[3]; //파부가 현재 장착하고 있는 무기가 올려주는 수치
	
		//크리 원래 수치 구하기
		Skill kree = new Skill(armedK.attack - weaponK.attack, armedK.power - weaponK.power, armedK.strikeP - weaponK.strikeP, armedK.strikeD - weaponK.strikeD, armedK.speed - weaponK.speed);
		//파부 원래 수치 구하기
		Skill pabu = new Skill(armedP.attack - weaponP.attack, armedP.power - weaponP.power, armedP.strikeP - weaponP.strikeP, armedP.strikeD - weaponP.strikeD, armedP.speed - weaponP.speed);
		
		//크리가 파부의 무기를 장착
		Skill crossedK = new Skill(kree.attack + weaponP.attack, kree.power + weaponP.power, kree.strikeP + weaponP.strikeP, kree.strikeD + weaponP.strikeD, kree.speed + weaponP.speed);
		//파부가 크리의 무기를 장착
		Skill crossedP = new Skill(pabu.attack + weaponK.attack, pabu.power + weaponK.power, pabu.strikeP + weaponK.strikeP, pabu.strikeD + weaponK.strikeD, pabu.speed + weaponK.speed);
		
		//무기를 장착한 크리의 전투력 - 파부의 무기를 장착한 크리 전투력
		double diffK = calPower(armedK) - calPower(crossedK);
		double diffP = calPower(armedP) - calPower(crossedP);
		
//		System.out.println((int)diffK);
//		System.out.println((int)diffP);
		
		//정답 도출
		System.out.println(getAnswer((int)diffK));
		System.out.println(getAnswer((int)diffP));
	}
	
	static char getAnswer(int diff) {
		if(diff < 0) { //차이가 음수이면 증가한것 
			return '+';
		}else if(diff > 0) { //차이가 양수이면 감소한것 
			return '-';
		}else {
			return '0';
		}
	}

	static double calPower(Skill skill) {
		return skill.attack * (1.0 + skill.power / 100.0) * 
				((1.0- Math.min(skill.strikeP / 100.0, 1.0)) +
				Math.min(skill.strikeP / 100.0, 1.0) *
				(skill.strikeD / 100.0)
				) * (1.0 + skill.speed / 100.0);
	}

}

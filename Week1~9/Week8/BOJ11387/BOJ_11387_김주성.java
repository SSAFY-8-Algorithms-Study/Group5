import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static double[] A, B, AW, BW;

    static void input() throws IOException {
        A = new double[5];
        B = new double[5];
        AW = new double[5];
        BW = new double[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            A[i] = Double.parseDouble(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            B[i] = Double.parseDouble(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            AW[i] = Double.parseDouble(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            BW[i] = Double.parseDouble(st.nextToken());
        }
    }

    static double calculation(double op0, double op1, double op2, double op3, double op4) {
        return op0 * (100+op1) * (100*(100-Math.min(op2,100)) + Math.min(op2,100) * op3) * (100+op4);
    }

    static void pro() {
        double power_A_AW = calculation(A[0], A[1], A[2], A[3], A[4]);
        double power_A_BW = calculation(A[0]-AW[0]+BW[0], A[1]-AW[1]+BW[1], A[2]-AW[2]+BW[2], A[3]-AW[3]+BW[3], A[4]-AW[4]+BW[4]);
        double power_B_BW = calculation(B[0], B[1], B[2], B[3], B[4]);
        double power_B_AW = calculation(B[0]-BW[0]+AW[0], B[1]-BW[1]+AW[1], B[2]-BW[2]+AW[2], B[3]-BW[3]+AW[3], B[4]-BW[4]+AW[4]);
//        System.out.println("power_A_AW: "+ power_A_AW);
//        System.out.println("power_A_BW: "+ power_A_BW);
//        System.out.println("power_B_BW: "+ power_B_BW);
//        System.out.println("power_B_AW: "+ power_B_AW);
        if (power_A_AW == power_A_BW) {
            System.out.println(0);
        } else {
            System.out.println(power_A_AW > power_A_BW ? '-' : '+');
        }
        if (power_B_BW == power_B_AW) {
            System.out.println(0);
        } else {
            System.out.println(power_B_BW > power_B_AW ? '-' : '+');
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.print(sb.toString());
    }
}

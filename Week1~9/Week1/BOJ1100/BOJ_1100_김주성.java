import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for(int i = 1; i <= 8; i++){
            String line = br.readLine();
            if(i % 2 == 1){
                for(int k = 0; k < line.length(); k+=2){
                    if(line.charAt(k) == 'F'){
                        count++;
                    }
                }
            }else{
                for(int k = 1; k < line.length(); k+=2){
                    if(line.charAt(k) == 'F'){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

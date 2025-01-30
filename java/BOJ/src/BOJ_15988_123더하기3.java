import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15988_123더하기3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] list = new long[1000010];
        list[1] = 1; // 1
        list[2] = 2; // 1+1, 2
        list[3] = 4; // 1+1+1, 1+2, 2+1, 3
        list[4] = 7; // 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1
        // list[4] = list[1] + list[2] + list[3]
        for(int i=5; i<1000010; i++){
            list[i] = (list[i-3] + list[i-2] + list[i-1]) % 1000000009;
        }

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine()); // 1 <= num <= 1,000,000
            System.out.println(list[num]);
        }
    }
}

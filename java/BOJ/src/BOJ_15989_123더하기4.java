import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15989_123더하기4 {
    public static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            ans = 0;
            calc(num, 0, 0, 1);
            System.out.println(ans);
        }
    }

    public static void calc(int num, int count, int sum, int offset) {
        if(num <= sum) {
            if(num == sum) ans++;
            return;
        }
        for(int i=offset; i<=3; i++) {
            calc(num, count+1, sum+i, i);
        }
    }
}

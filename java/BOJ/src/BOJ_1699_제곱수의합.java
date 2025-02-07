import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1699_제곱수의합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 100,000
        // test case
        // 18 -> 2 ( != 3 )

        int size = (int)Math.sqrt(n);
        int[] dp = new int[n+1];
        int[] list = new int[size+1];
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i=1; i<= size; i++) {
            dp[i*i] = 1;
            queue.add(i*i);
            list[i] = i;
        }

        while(!queue.isEmpty()) {
            int num = queue.poll();
            for(int i=1; i<size; i++) {
                int target = num + (i*i);
                if(target <=n && dp[num] + 1 < dp[target]) {
                    dp[target] = dp[num] + 1;
                    queue.add(target);
                }
            }
        }

        System.out.println(dp[n]);
    }

}

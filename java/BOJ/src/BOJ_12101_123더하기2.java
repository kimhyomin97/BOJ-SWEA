import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_12101_123더하기2 {
    public static int count = 0;
    public static int k = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 <= n <= 11
        k = Integer.parseInt(st.nextToken()); // 1 <= k <= 2^31 - 1

        calc(n, 0, new Stack<Integer>());
        if(count < k) System.out.println(-1);
    }

    public static void calc(int num, int sum, Stack<Integer> ans) {
        if(count >= k) {
            return;
        }
        if(num <= sum) {
            if(num == sum) {
                count++;
                if(count == k) {
                    StringBuilder sb = new StringBuilder();
                    for(int ansNum : ans) {
                        sb.append(ansNum).append("+");
                    }
                    sb.setLength(sb.length()-1);
                    System.out.println(sb);
                }
            }
            return;
        }

        for(int i=1; i<=3; i++) {
            ans.add(i);
            calc(num, sum+i, ans);
            ans.pop();
        }
    }

    public static void calc(int num, int count, int sum, int offset) {
        if(num <= sum) {
            if(num == sum) {
                count++;
            }
            return;
        }
        for(int i=offset; i<=3; i++) {
            calc(num, count+1, sum+i, i);
        }
    }
}

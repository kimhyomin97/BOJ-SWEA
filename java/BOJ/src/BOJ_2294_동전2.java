import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294_동전2 {
    public static int n = 0;
    public static int k = 0;
    public static int ans = Integer.MAX_VALUE; // k를 만드는데 사용한 동전의 최소 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 1 <= n <= 100
        k = Integer.parseInt(st.nextToken()); // 1 <= k <= 10,000
        int[] list = new int[n]; // 1 <= list[i] <= 100,000

        for(int i=0; i<n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }


        Arrays.sort(list);
        recur(0, 0, list);

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
    public static void recur(int count, int sum, int[] list) {
        if(sum == k) {
            if(count < ans) ans = count;
            return;
        }
        if(count >= ans) return;
        for(int i=n-1; i>=0; i--) {
            if(sum + list[i] <= k) {
                recur(count + 1, sum + list[i], list);
            }
        }
    }
}

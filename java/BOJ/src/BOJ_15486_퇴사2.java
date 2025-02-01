import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486_퇴사2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1<= n <= 1,500,000
        int[][] list = new int[2][n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            list[0][i] = Integer.parseInt(st.nextToken()); // 상담기간 1 <= T <= 50
            list[1][i] = Integer.parseInt(st.nextToken()); // 상담금액 1 <= P <= 1,000
        }

        int[] ans = new int[n+2];
        for(int i=0; i<=n+1; i++) ans[i] = 0;

        for(int i=n; i>0; i--) {
            int offset = list[0][i];
            int cost = list[1][i];
            if(i+offset <= n+1) {
                if(cost + ans[i+offset] > ans[i+1]) {
                    ans[i] = cost + ans[i+offset];
                } else {
                    ans[i] = ans[i+1];
                }
            } else {
                ans[i] = ans[i+1];
            }
        }
        System.out.println(ans[1]);
    }
}

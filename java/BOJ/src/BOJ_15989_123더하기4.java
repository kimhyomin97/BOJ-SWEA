import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15989_123더하기4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[10001][10001];
        // list[x][1] = 1을 더해서 x가 되는 경우
        // list[x][2] = 2를 더해서 x가 되는 경우
        // list[x][3] = 3을 더해서 x가 되는 경우

        list[1][1] = 1; // 1
        list[1][2] = 0;
        list[1][3] = 0;

        list[2][1] = 1; // 1+1
        list[2][2] = 1; // 2
        list[2][3] = 0;

        list[3][1] = 1; // 1+1+1
        list[3][2] = 1; // 1+2
        list[3][3] = 1; // 3

        list[4][1] = 1; // 1+1+1+1
        list[4][2] = 2; // 1+1+2, 2+2
        list[4][3] = 1; // 1+3

        list[5][1] = 1; // 1+1+1+1+1
        list[5][2] = 2; // 1+1+1+2, 1+2+2
        list[5][3] = 2; // 1+1+3, 2+3
        // list[5][1] = list[4][1]      (list[4][2], list[4][3]은 중복)
        // list[5][2] = list[3][1] + list[3][2]     (list[3][3]은 중복)
        // list[5][3] = list[2][1] + list[2][2] + list[2][3]

        for(int i=6; i<=10000; i++) {
            list[i][1] = 1;
            list[i][2] = list[i-2][1] + list[i-2][2];
            list[i][3] = list[i-3][1] + list[i-3][2] + list[i-3][3];
        }

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(list[num][1]+list[num][2]+list[num][3]);
        }
    }
}

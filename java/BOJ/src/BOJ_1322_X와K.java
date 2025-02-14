import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1322_X와K {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken()); // 0 < x, k < 2,000,000,000 (20억)
        int k = Integer.parseInt(st.nextToken());

        int[] xBit = new int[33];
        int[] kBit = new int[33];
        transToBinary(x, xBit);
        transToBinary(k, kBit);

        int[] ansBit = new int[65];
        Arrays.fill(ansBit, 0);

        int xIndex = 32;
        int kIndex = 32;
        while(kIndex>=0) {
            int target = kBit[kIndex];

            if(xIndex >= 0 && xBit[xIndex] == 1) {
                xIndex--;
            } else {
                ansBit[32+xIndex] = target;
                kIndex--;
                xIndex--;
            }
        }

        System.out.println(transToDecimal(ansBit));
    }

    public static void transToBinary(int num, int[] list) {
        for(int i=1; i<=32; i++) {
            if(num >= Math.pow(2, 32-i)) {
                list[i] = 1;
                num -= Math.pow(2, 32-i);
            } else {
                list[i] = 0;
            }
        }
    }

    public static long transToDecimal(int[] list) {
        long num = 0;
        for(int i=1; i<=64; i++) {
            if(list[i] == 1) {
                num += Math.pow(2, 64-i);
            }
        }
        return num;
    }
}

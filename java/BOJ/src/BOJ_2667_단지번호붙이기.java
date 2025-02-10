import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667_단지번호붙이기 {

    public static class info {
        public int row;
        public int col;
        public info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 5 <= n <= 25
        int[][] map = new int[n][n]; // map[i][j] = 0 or 1
        int[][] visit = new int[n][n];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            Arrays.fill(visit[i], 0);
            for(int j=0; j<n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int offset = 1;
        int count = 1;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        Queue<info> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1 && visit[i][j] == 0) {
                    queue.add(new info(i, j));
                    visit[i][j] = offset;
                    count = 1;
                    while(!queue.isEmpty()) {
                        info now = queue.poll();
                        for(int k=0; k<4; k++) {
                            int nr = now.row + dr[k];
                            int nc = now.col + dc[k];
                            if(nr>=0 && nr<n && nc>=0 && nc<n && map[nr][nc]==1 && visit[nr][nc]==0) {
                                visit[nr][nc] = offset;
                                count++;
                                queue.add(new info(nr, nc));
                            }
                        }
                    }
                    offset++;
                    ans.add(count);
                }
            }
        }

        System.out.println(ans.size());
        Collections.sort(ans);

        for(int num : ans) {
            System.out.println(num);
        }

    }
}

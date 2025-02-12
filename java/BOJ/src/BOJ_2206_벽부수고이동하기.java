import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {

    public static class info{
        public int row;
        public int col;
        public int offset;
        public info(int row, int col, int offset) {
            this.row = row;
            this.col = col;
            this.offset = offset;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] visit = new int[n][m]; // offset 0
        int[][] visit2 = new int[n][m]; // offset 1

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = line.charAt(j) - '0';
                visit[i][j] = Integer.MAX_VALUE;
                visit2[i][j] = Integer.MAX_VALUE;
            }
        }
        // TODO : (1, 1) -> (n, m) 최단경로
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        Queue<info> queue = new LinkedList<>();
        queue.add(new info(0, 0, 0));
        visit[0][0] = 1;
        visit2[0][0] = 1;

        while(!queue.isEmpty()){
            info now = queue.poll();

            for(int i=0; i<4; i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                int offset = now.offset;
                if(nr>=0 && nr<n && nc>=0 && nc<m) {
                    if(offset == 0) {
                        if(map[nr][nc] == 0 && visit[now.row][now.col]+1 < visit[nr][nc]) {
                            visit[nr][nc] = visit[now.row][now.col] + 1;
                            queue.add(new info(nr, nc, offset));
                        } else if(map[nr][nc] == 1 && visit[now.row][now.col]+1 < visit2[nr][nc]) {
                            visit2[nr][nc] = visit[now.row][now.col] + 1;
                            queue.add(new info(nr, nc, 1));
                        }
                    } else if (offset == 1) {
                        if(map[nr][nc] == 0 && visit2[now.row][now.col]+1 < visit2[nr][nc]) {
                            visit2[nr][nc] = visit2[now.row][now.col] + 1;
                            queue.add(new info(nr, nc, offset));
                        }
                    }
                }
            }
        }

        int ans = Math.min(visit[n-1][m-1], visit2[n-1][m-1]);

        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);

    }
}

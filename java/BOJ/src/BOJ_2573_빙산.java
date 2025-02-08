import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        Queue<info> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) queue.add(new info(i, j));
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int size = queue.size();
        int count = 0;
        int year = 1;
        int ans = 0;
        int[][] visit = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(visit[i], 0);

        while(!queue.isEmpty()) {
            info now = queue.poll();

            count++;
            if(count == size) {
                size = queue.size();
                count = 0;
                year++;
                for(int i=0; i<n; i++) Arrays.fill(visit[i], 0);
            }

            for(int i=0; i<4; i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m) { // 유효범위 확인
                    if(map[nr][nc] <= 0) {
                        // 접한 부분이 바닷물인 경우
                        map[now.row][now.col]--;
                        if(map[now.row][now.col] > 0) queue.add(new info(now.row, now.col));
                    } else if(map[nr][nc] > 0) {
                        // 접한 부분이 빙산인 경우
                        if(visit[now.row][now.col] == 0) {
                            if(visit[nr][nc] > 0) {
                                // 동일한 덩어리인지 체크
                                visit[now.row][now.col] = visit[nr][nc];
                            } else {
                                int visitNum = 0;
                                for(int j=0; j<4; j++) {
                                    int visitNr = now.row + dr[j];
                                    int visitNc = now.col + dc[j];
                                    if(visitNr>=0 && visitNr<n && visitNc>=0 && visitNc<m) {
                                        if(visit[visitNr][visitNc] > 0) {
                                            visitNum = visit[visitNr][visitNc];
                                        }
                                    }
                                }
                                if(visitNum == 0) {
                                    ans++;
                                    visit[now.row][now.col] = ans;
                                    if(ans >= 2) {
                                        System.out.println(year);
                                        return;
                                    }
                                } else {
                                    visit[now.row][now.col] = visitNum;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }
}

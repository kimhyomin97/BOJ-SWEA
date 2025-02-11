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
        int[][] visit = new int[n][m];
        Queue<info> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(visit[i], 0);
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) queue.add(new info(i, j));
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        Queue<info> popList = new LinkedList<>();
        int year = 1;
        int size = queue.size();
        int count = 0;

        while(!queue.isEmpty()) {
            info now = queue.poll();

            for(int i=0; i<4; i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && map[nr][nc] == 0) {
                    popList.add(new info(now.row, now.col));
                }
            }

            count++;
            if(count == size) {
                // 빙하 녹이기
                while(!popList.isEmpty()) {
                    info popNow = popList.poll();
                    if(map[popNow.row][popNow.col] != 0) {
                        map[popNow.row][popNow.col]--;
                    }
                }

                // 덩어리 계산
                int section = 0;
                Queue<info> sectionList = new LinkedList<>();
                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        if(map[i][j] > 0) {
                            queue.add(new info(i, j));
                            if(visit[i][j] == 0) {
                                section++;
                                visit[i][j] = section;
                                sectionList.add(new info(i, j));
                                while (!sectionList.isEmpty()) {
                                    info sectionNow = sectionList.poll();
                                    for (int k = 0; k < 4; k++) {
                                        int nr = sectionNow.row + dr[k];
                                        int nc = sectionNow.col + dc[k];
                                        if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] > 0 && visit[nr][nc] == 0) {
                                            visit[nr][nc] = section;
                                            sectionList.add(new info(nr, nc));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if(section >= 2) {
                    System.out.println(year);
                    return;
                }

                // 초기화
                size = queue.size();
                count = 0;
                year++;
                for(int i=0; i<n; i++) Arrays.fill(visit[i], 0);
            }
        }

        System.out.println(0);
    }
}

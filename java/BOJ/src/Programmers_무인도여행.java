import java.util.*;

class Programmers_무인도여행 {
    public class info {
        public int row;
        public int col;
        public info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        int row = maps.length;
        int col = maps[0].length();
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        boolean[][] visit = new boolean[row][col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                char nowChar = maps[i].charAt(j);
                if('X' != nowChar && visit[i][j] == false){
                    Queue<info> queue = new LinkedList<>();
                    queue.add(new info(i, j));
                    int sum = nowChar-'0';
                    visit[i][j] = true;

                    while(queue.size() != 0) {
                        info now = queue.poll();
                        for(int k=0; k<4; k++) {
                            int nr = now.row + dr[k];
                            int nc = now.col + dc[k];
                            if(nr>=0&&nr<row&&nc>=0&&nc<col&&'X'!=maps[nr].charAt(nc)&&visit[nr][nc]==false) {
                                sum += maps[nr].charAt(nc) - '0';
                                queue.add(new info(nr, nc));
                                visit[nr][nc] = true;
                            }
                        }
                    }

                    if(sum != 0) {
                        list.add(sum);
                    }

                }
            }
        }
        if(list.size() == 0){
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size();i++) {
            answer[i]=list.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }
}


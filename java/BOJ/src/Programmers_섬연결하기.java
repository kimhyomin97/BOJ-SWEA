import java.util.*;

public class Programmers_섬연결하기 {
    public class info implements Comparable<info>{
        int start;
        int end;
        int cost;
        public info(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(info info) {
            return Integer.compare(this.cost, info.cost);
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        ArrayList<ArrayList<info>> list = new ArrayList<>();

        for(int i=0; i<n; i++) list.add(new ArrayList<>());

        for(int i=0; i<costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];
            list.get(start).add(new info(start, end, cost));
            list.get(end).add(new info(end, start, cost));
        }

        PriorityQueue<info> queue = new PriorityQueue<>();
        visit[0] = true;
        for(int i=0; i<list.get(0).size(); i++){
            queue.add(list.get(0).get(i));
        }

        while(!queue.isEmpty()) {
            info now = queue.poll();
            if(visit[now.end]==false){
                visit[now.end] = true;
                answer += now.cost;
                for(int i=0; i<list.get(now.end).size(); i++){
                    queue.add(list.get(now.end).get(i));
                }
            }
        }

        return answer;
    }
}
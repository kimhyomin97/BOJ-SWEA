import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972_택배배송_2 {
    public static class info implements Comparable<info> {
        public int dest;
        public int cost;
        public info(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
        @Override
        public int compareTo(info info) {
            return this.cost - info.cost;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<info>> list = new ArrayList<>();
        for(int i=0; i<=n; i++) list.add(new ArrayList<>());

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new info(dest, cost));
            list.get(dest).add(new info(start, cost));
        }

        PriorityQueue<info> pq = new PriorityQueue<>();
        int[] dij = new int[n+1];
        for(int i=0; i<=n; i++) dij[i] = Integer.MAX_VALUE;
        dij[1] = 0;
        pq.add(new info(1, 0));

        while(!pq.isEmpty()) {
            info now = pq.poll();
            for(int i=0; i<list.get(now.dest).size(); i++){
                info next = list.get(now.dest).get(i);
                if(dij[now.dest] + next.cost < dij[next.dest]) {
                    dij[next.dest] = dij[now.dest] + next.cost;
                    pq.add(new info( next.dest, dij[next.dest]));
                }
            }
        }

        System.out.println(dij[n]);
    }
}

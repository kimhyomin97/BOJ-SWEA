import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972_택배배송 {
    public static class info implements Comparable<info> {
        public int start;
        public int dest;
        public int cost;
        public info(int start, int dest, int cost) {
            this.start = start;
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
            list.get(start).add(new info(start, dest, cost));
            list.get(dest).add(new info(dest, start, cost));
        }

        PriorityQueue<info> pq = new PriorityQueue<>();
        int[] dij = new int[n+1];
        for(int i=0; i<=n; i++) dij[i] = Integer.MAX_VALUE;
        dij[1] = 0;
        for(int i=0; i<list.get(1).size(); i++) {
            pq.add(list.get(1).get(i));
        }

        while(!pq.isEmpty()) {
            info now = pq.poll();
            if(dij[now.start] + now.cost < dij[now.dest]) {
                dij[now.dest] = dij[now.start] + now.cost;
                for(int j=0; j<list.get(now.dest).size(); j++) {
                    pq.add(list.get(now.dest).get(j));
                }
            }
        }

        System.out.println(dij[n]);
    }
}

import java.util.*;

class Programmers_부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer> answer = new ArrayList<>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++) list.add(new ArrayList<>());

        for(int i=0; i<roads.length; i++) {
            list.get(roads[i][0]).add(roads[i][1]);
            list.get(roads[i][1]).add(roads[i][0]);
        }

        int sum = 0;
        int[] dij = new int[n+1];

        for(int j=0; j<n+1; j++) dij[j]=Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        dij[destination] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int j=0; j<list.get(now).size(); j++) {
                int dest = list.get(now).get(j);
                if(dij[now]+1 < dij[dest]){
                    queue.add(dest);
                    dij[dest] = dij[now]+1;
                }
            }
        }

        for(int j=0; j<sources.length; j++) {
            if(dij[sources[j]] == Integer.MAX_VALUE){
                answer.add(-1);
            } else {
                answer.add(dij[sources[j]]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
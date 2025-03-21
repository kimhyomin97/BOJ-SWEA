import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1707_이분그래프 {
    // 이분그래프 : 그래프의 모든 정점을 두가지 색으로 표현 가능하고, 연결된 두 정점의 색깔이 항상 다른 경우
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for(int tCase=0; tCase<k; tCase++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 정점의 개수
            int e = Integer.parseInt(st.nextToken()); // 간선의 개수

            ArrayList<ArrayList<Integer>> map = new ArrayList<>();
            for(int i=0; i<=v; i++) map.add(new ArrayList<>());

            for(int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                map.get(start).add(end);
                map.get(end).add(start);
            }

            boolean flag = true;
            int[] colors = new int[v+1];
            Arrays.fill(colors, 0);
            Queue<Integer> queue = new LinkedList<>();

            for(int i=1; i<=v; i++) {
                if(colors[i]==0) {
                    colors[i] = 1;
                    queue.add(i);
                }
                while(!queue.isEmpty()) {
                    int now = queue.poll();

                    for(int j=0; j<map.get(now).size(); j++) {
                        int target = map.get(now).get(j);
                        if(colors[target] == 0) {
//                            colors[target] = colors[now] * -1;
                            queue.add(target);
                        }
                        if(colors[target] == colors[now]) {
                            flag = false;
                        }
                    }
                }
            }

            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

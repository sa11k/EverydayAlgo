import java.io.*;
import java.util.*;

class Node {
    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());        // 도시의 개수
        int m = Integer.parseInt(br.readLine());        // 버스의 개수

        List<Node>[] list = new List[n+1];
        boolean[] visited = new boolean[n+1];
        List<Integer>[] result_city = new List[n+1];
        int[] result_cost = new int[n+1];

        for(int i = 1; i<=n; i++) {
            list[i] = new ArrayList<>();
            result_city[i] = new ArrayList<>();
            result_cost[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        result_city[start].add(start);
        result_cost[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if(result_cost[now.end] < now.cost) continue;
            if(!visited[now.end]) visited[now.end] = true;
            for(int i = 0; i<list[now.end].size(); i++) {
                Node next = list[now.end].get(i);
                if(!visited[next.end] && now.cost + next.cost <= result_cost[next.end]) {
                    result_cost[next.end] = now.cost + next.cost;
                    result_city[next.end].clear();
                    for(int j = 0; j<result_city[now.end].size(); j++) {
                        result_city[next.end].add(result_city[now.end].get(j));
                    }
                    result_city[next.end].add(next.end);
                    queue.add(new Node(next.end, result_cost[next.end]));
                }
            }
        }

        sb.append(result_cost[end]).append("\n").append(result_city[end].size()).append("\n");
        for(int i = 0; i<result_city[end].size(); i++) {
            sb.append(result_city[end].get(i) + " ");
        }

        System.out.println(sb);
    }
}
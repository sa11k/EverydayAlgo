import java.util.*;
import java.io.*;

class Node {
    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}

public class Main {
    static int N, M, K;
    static List<Node>[] list;
    static boolean[] visit;
    static int[] cost;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        visit = new boolean[N+1];
        cost = new int[N+1];

        for(int i = 1; i<=N; i++) list[i] = new ArrayList<>();

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        for(int i = 1; i<=N; i++) dijkstra(i);

        for(int i = 1; i<=N; i++) {
            result = Math.max(result, cost[i]);
        }

        System.out.println(result);
    }

    static void dijkstra(int start) {
        boolean[] visit = new boolean[N+1];
        int[] min = new int[N+1];

        for(int i = 1; i<=N; i++) min[i] = Integer.MAX_VALUE;

        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        min[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if(min[now.end] < now.cost) continue;
            if(!visit[now.end]) visit[now.end] = true;
            for(int i = 0; i<list[now.end].size(); i++) {
                Node next = list[now.end].get(i);
                if(!visit[next.end] && now.cost + next.cost < min[next.end]) {
                    min[next.end] = now.cost + next.cost;
                    queue.add(new Node(next.end, min[next.end]));
                }
            }
        }
        cost[start] += min[K];

        if(start == K)
            for(int i = 1; i<=N; i++) {
                cost[i] += min[i];
            }
    }
}
import java.io.*;
import java.util.*;

class Node {
    int end;
    int weight;

    public Node (int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static int n, m;
    static List<Node>[] list;
    static int[][] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n+1];
        result = new int[n][n];

        for(int i = 1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        for(int i = 1; i<=n; i++)
            dijkstra(i);

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if (i == j) sb.append("- ");
                else sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        boolean[] visit = new boolean[n+1];
        int[] min = new int[n+1];

        for(int i = 1; i<=n; i++) min[i] = Integer.MAX_VALUE;

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        min[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if(min[now.end] < now.weight) continue;
            if(!visit[now.end]) visit[now.end] = true;
            for(int i = 0; i<list[now.end].size(); i++) {
                Node next = list[now.end].get(i);
                if(!visit[next.end] && now.weight + next.weight < min[next.end]) {
                    min[next.end] = now.weight + next.weight;
                    result[next.end-1][start-1] = now.end;
                    queue.add(new Node(next.end, min[next.end]));
                }
            }
        }
    }
}
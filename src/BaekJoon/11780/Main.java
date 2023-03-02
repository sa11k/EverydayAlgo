import java.io.*;
import java.util.*;

class Node {
    int end;
    int cost;

    public Node (int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}

public class Main {
    static int n, m;
    static List<Node>[] list;
    static List<Integer>[][] minWay;
    static int[][] minCost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());        // 도시의 개수
        m = Integer.parseInt(br.readLine());        // 버스의 개수

        list = new List[n+1];               // 버스 정보 저장 list
        minWay = new List[n+1][n+1];        // 최소 비용으로 가는 경로 저장
        minCost = new int[n+1][n+1];        // 최소 비용 저장 배열

        for(int i = 1; i<=n; i++) {
            list[i] = new ArrayList<>();
            for(int j = 1; j<=n; j++) {
                minCost[i][j] = Integer.MAX_VALUE;
                minWay[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
        }

        for(int i = 1; i<=n; i++) dijkstra(i);

        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n; j++) {
                if(minCost[i][j] != Integer.MAX_VALUE)
                    sb.append(minCost[i][j]).append(" ");
                else
                    sb.append(0).append(" ");
            }
            sb.append("\n");
        }

        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n; j++) {
                if(minWay[i][j].size() == 1) sb.append(0).append("\n");
                else {
                    sb.append(minWay[i][j].size()).append(" ");
                    for(int k = 0; k<minWay[i][j].size(); k++)
                        sb.append(minWay[i][j].get(k)).append(" ");
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        boolean[] visit = new boolean[n+1];
        minCost[start][start] = 0;
        minWay[start][start].add(start);
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if(minCost[start][now.end] < now.cost) continue;
            if(!visit[now.end]) visit[now.end] = true;
            for(int i = 0; i<list[now.end].size(); i++) {
                Node next = list[now.end].get(i);
                if(!visit[next.end] && now.cost + next.cost < minCost[start][next.end]) {
                    minCost[start][next.end] = now.cost + next.cost;
                    minWay[start][next.end].clear();
                    for(int j = 0; j<minWay[start][now.end].size(); j++) {
                        minWay[start][next.end].add(minWay[start][now.end].get(j));
                    }
                    minWay[start][next.end].add(next.end);
                    queue.add(new Node(next.end, minCost[start][next.end]));
                }
            }
        }
    }
}
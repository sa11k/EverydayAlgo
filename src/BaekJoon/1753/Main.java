import java.io.*;
import java.util.*;

class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        boolean[] visit = new boolean[V+1];     // 방문 처리 배열
        int[] result = new int[V+1];            // 최단 경로 값 저장 배열
        List<Node>[] list = new List[V+1];      // 연결 정보 저장 배열

        for(int i = 1; i<=V; i++) {
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());       // 출발
            int v = Integer.parseInt(st.nextToken());       // 도착
            int w = Integer.parseInt(st.nextToken());       // 가중치

            list[u].add(new Node(v, w));
        }

        // 다익스트라
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        result[K] = 0;
        queue.add(new Node(K, 0));

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(!visit[now.end]) visit[now.end] = true;
            for(int i = 0; i<list[now.end].size(); i++) {
                Node next = list[now.end].get(i);
                if(!visit[next.end] && now.weight + next.weight < result[next.end]) {
                    result[next.end] = now.weight + next.weight;
                    queue.add(new Node(next.end, result[next.end]));
                }
            }
        }

        for(int i = 1; i<=V; i++) {
            if(result[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(result[i]);
        }
    }
}
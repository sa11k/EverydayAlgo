import java.io.*;
import java.util.*;

class Node {
    int i;
    int j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int N;
    static Node sNode, fNode;
    static List<Node> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++) {
            list = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            for(int i = 0; i<N+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if(i == 0)
                    sNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                else if(i == N+1)
                    fNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                else
                    list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            BFS();
        }
    }

    static void BFS() {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.add(sNode);
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if(Math.abs(now.i - fNode.i) + Math.abs(now.j - fNode.j) <= 1000) {
                System.out.println("happy");
                return;
            }

            for(int i = 0; i<N; i++) {
                if(!visited[i]) {
                    Node next = list.get(i);
                    if(Math.abs(now.i - next.i) + Math.abs(now.j - next.j) <= 1000) {
                        visited[i] = true;
                        queue.add(next);
                    }
                }
            }
        }

        System.out.println("sad");
        return;
    }
}
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
    static int w, h, nowI, nowJ;
    static char[][] map;
    static Queue<Node> fire;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            fire = new LinkedList<>();

            for(int i = 0; i<h; i++) {
                String s = br.readLine();
                for(int j = 0; j<w; j++) {
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '@') {
                        nowI = i;
                        nowJ = j;
                    }
                    else if(map[i][j] == '*') {
                        fire.add(new Node(i, j));
                    }
                }
            }

            escape(nowI, nowJ);
        }
        System.out.println(sb);
    }

    public static void escape(int nowI, int nowJ) {
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[h][w];
        visited[nowI][nowJ] = true;
        queue.add(new Node(-1, -1));
        queue.add(new Node(nowI, nowJ));
        int time = -1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if(now.i == -1 && now.j == -1) {
                burn();
                if(!queue.isEmpty()) {
                    queue.add(now);
                }
                time++;
                continue;
            }

            int[] di = {1, 0, -1, 0};
            int[] dj = {0, 1, 0, -1};

            for(int d = 0; d<4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if(ni >= h || nj >= w || ni < 0 || nj <0) {
                    sb.append(time+1).append("\n");
                    return;
                }

                if(map[ni][nj] == '.' && !visited[ni][nj]) {
                    queue.add(new Node(ni, nj));
                    visited[ni][nj] = true;
                }
            }
        }

        sb.append("IMPOSSIBLE\n");
    }

    public static void burn() {
        int size = fire.size();

        for(int i = 0; i<size; i++) {
            Node now = fire.poll();

            int[] di = {1, 0, -1, 0};
            int[] dj = {0, 1, 0, -1};

            for(int d = 0; d<4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if(ni >= 0 && nj >= 0 && ni < h && nj <w && (map[ni][nj] == '.' || map[ni][nj] == '@')) {
                    fire.add(new Node(ni, nj));
                    map[ni][nj] = '*';
                }
            }
        }
    }
}
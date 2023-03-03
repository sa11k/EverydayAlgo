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
    static int N, M, num, result;
    static int[][] room, tmp;
    static List<Node> list;
    static Node[] firstVirus;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = N*N;
        result = Integer.MAX_VALUE;

        room = new int[N][N];
        tmp = new int[N][N];
        list = new ArrayList<>();
        firstVirus = new Node[M];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] != 0) num--;
                if(room[i][j] == 2)
                    list.add(new Node(i, j));
            }
        }

        selectVirus(0, 0);

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);

    }

    static void selectVirus(int cnt, int start) {
        if(cnt == M) {
            for(int i = 0; i<N; i++) {
                for(int j = 0; j<N; j++) {
                    tmp[i][j] = room[i][j];
                }
            }

            virus(firstVirus, tmp);

            return;
        }

        for(int i = start; i<list.size(); i++) {
            firstVirus[cnt] = list.get(i);
            selectVirus(cnt+1, i+1);
        }
    }

    static void virus(Node[] firstVirus, int[][] tmp) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(-1, -1));
        int cnt = num;
        for(int i = 0; i<firstVirus.length; i++) {
            queue.add(firstVirus[i]);
            tmp[firstVirus[i].i][firstVirus[i].j] = 3;
        }
        int time = 0;

        if(cnt == 0){
            result = 0;
            return;
        }

        while(!queue.isEmpty()) {

            Node now = queue.poll();

            if(now.i == -1 && now.j == -1) {
                if(!queue.isEmpty()) queue.add(now);
                time++;
                continue;
            }

            int[] di = {-1, 0, 1, 0};
            int[] dj = {0, 1, 0, -1};

            for(int d = 0; d<4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if(ni < N && nj <N && ni >= 0 && nj >= 0 && tmp[ni][nj] != 1 && tmp[ni][nj] != 3) {
                    if(tmp[ni][nj] == 0) cnt--;
                    queue.add(new Node(ni, nj));
                    tmp[ni][nj] = 3;
                }
            }

            if(cnt == 0) {
                result = Math.min(result, time);
                break;
            }
        }

//        System.out.println(time + " " + cnt);

//        for(int i = 0; i<N; i++) {
//            for(int j = 0; j<N; j++) {
//                System.out.print(tmp[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();

        if(cnt == 0) result = Math.min(result, time);
    }
}
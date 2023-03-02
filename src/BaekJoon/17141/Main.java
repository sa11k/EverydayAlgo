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
    static Node[] firstVirus;
    static List<Node> list;

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
                if(room[i][j] != 0) {
                    if(room[i][j] == 2) {
                        room[i][j] = 0;
                        list.add(new Node(i, j));
                    }
                    else{
                        num--;
                    }
                }
            }
        }

        checkVirus(0, 0);

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    static void checkVirus(int cnt, int start) {
        if(cnt == M){
            for(int i = 0; i<N; i++) {
                for(int j = 0; j<N; j++) {
                    tmp[i][j] = room[i][j];
                }
            }
            virus(firstVirus, tmp);
            return;
        }

        for(int i = start; i<list.size(); i++) {
            if(room[list.get(i).i][list.get(i).j] != 0) continue;

            firstVirus[cnt] = list.get(i);
            checkVirus(cnt+1, i+1);
        }
    }

    static void virus(Node[] firstVirus, int[][] tmp) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(-1, -1));
        int cnt = num;
        for(int i = 0; i<firstVirus.length; i++) {
            queue.add(firstVirus[i]);
            tmp[firstVirus[i].i][firstVirus[i].j] = 2;
            cnt--;
        }
        int time = -1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if(now.i == -1 && now.j == -1) {
                if(!queue.isEmpty())
                    queue.add(now);
                time++;
                continue;
            }

            int[] di = {1, 0, -1, 0};
            int[] dj = {0, 1, 0, -1};

            for(int d = 0; d<4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if(ni < N && nj <N && ni >= 0 && nj >= 0 && tmp[ni][nj] == 0) {
                    queue.add(new Node(ni, nj));
                    tmp[ni][nj] = 2;
                    cnt--;
                }
            }
        }

//        System.out.println(time-1+" "+cnt);
//        for(int i = 0; i<N; i++) {
//            for(int j = 0; j<N; j++) {
//                System.out.print(tmp[i][j] + " ");
//            }
//            System.out.println();
//        }

        if(cnt == 0) result = Math.min(result, time-1);

//        System.out.println(time-1+ " " +result);
//        System.out.println();
    }
}
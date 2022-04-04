import java.io.*;
import java.util.*;

public class Solution_swt_1767_프로세서연결하기_대전_5반_송다경 {
    static class Processor{
        int row, col;
        public Processor(int row, int col) {
            this.row = row; this.col = col;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int N,T;
    static int maxCore, result;
    static List<Processor> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == 0 || j == 0 || i == N-1 || j == N-1) continue;
                    if(map[i][j] == 1) list.add(new Processor(i,j));
                }
            }

            maxCore = Integer.MIN_VALUE;
            result = Integer.MAX_VALUE;

            dfs(0,0,0);

            System.out.println("#" + tc + " " + result);
        }
    }

    static void dfs(int idx, int coreCnt, int len) {
        if(idx == list.size()) {
            if(maxCore < coreCnt) {
                maxCore = coreCnt;
                result = len;
            }else if(maxCore == coreCnt) {
                if(result > len) result = len;
            }
            return;
        }

        int row = list.get(idx).row;
        int col = list.get(idx).col;
        for (int d = 0; d < 4; d++) {
            int count = 0;
            int nx = row;
            int ny = col;
            int Srow = row;
            int Scol = col;

            while(true) {
                nx += dx[d]; ny += dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                    break;
                if(map[nx][ny] == 1) {
                    count = 0;
                    break;
                }
                count++;
            }

            for (int i = 0; i < count; i++) {
                Srow += dx[d];
                Scol += dy[d];
                map[Srow][Scol] = 1;
            }

            if(count == 0)
                dfs(idx+1, coreCnt, len);

            else {
                dfs(idx+1, coreCnt+1, len + count);
                Srow = row; Scol = col;
                for (int i = 0; i < count; i++) {
                    Srow += dx[d];
                    Scol += dy[d];
                    map[Srow][Scol] = 0;
                }
            }
        }
    }
}

/*
3
7
0 0 1 0 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 1 0
0 0 0 0 0 0 0
1 1 0 1 0 0 0
0 1 0 0 0 0 0
0 0 0 0 0 0 0
9
0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 1 0 0
0 0 0 1 0 0 0 0 0
0 0 0 0 0 0 0 1 0
0 0 0 0 0 0 0 0 1
11
0 0 1 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 1
0 0 0 1 0 0 0 0 1 0 0
0 1 0 1 1 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 1 0 0
0 0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0
 */
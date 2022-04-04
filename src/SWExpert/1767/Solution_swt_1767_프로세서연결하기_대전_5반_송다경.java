import java.io.*;
import java.util.*;

public class Solution_swt_1767_프로세서연결하기_대전_5반_송다경 {
    static int N, result;
    static int[][] grid;
    static Deque<int[]> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){
            queue = new ArrayDeque<>();
            result = 0;
            N = Integer.parseInt(br.readLine());
            grid = new int[N][N];

            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j<N; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(grid[i][j] == 1)
                        result += solve(i, j);
                }
            }

            while(!queue.isEmpty()){
                int i = queue.peek()[0];
                int j = queue.peek()[1];
                int up = queue.peek()[2];
                int down = queue.peek()[3];
                int left = queue.peek()[4];
                int right = queue.peek()[5];

                if(up+down+left+right > Integer.MAX_VALUE*3){

                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    static int solve(int i, int j){
        System.out.println(i + " " + j);
        int cnt = 0;
        if(i == 0 || i == N-1 || j == 0 || j == N-1)
            return 0;

        int up = Integer.MAX_VALUE, down = Integer.MAX_VALUE, left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        for(int y = 0; y<i; y++){
            if(grid[y][j] == 1){
                up = Integer.MAX_VALUE;
                break;
            }
            up = i;
        }

        for(int y = i+1; y<N; y++){
            if(grid[y][j] == 1){
                down = Integer.MAX_VALUE;
                break;
            }
            down = N-i-1;
        }

        for(int x = 0; x<j; x++){
            if(grid[i][x] == 1){
                left = Integer.MAX_VALUE;
                break;
            }
            left = j;
        }

        for(int x = j+1; x<N; x++){
            if(grid[i][x] == 1){
                right = Integer.MAX_VALUE;
                break;
            }
            right = N-j-1;
        }

        System.out.println("up : " + up);
        System.out.println("down : " + down);
        System.out.println("left : " + left);
        System.out.println("right : " + right);

        queue.offer(new int[]{i, j, up, down, left, right});

        System.out.println("cnt : " + cnt);

        return cnt;
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
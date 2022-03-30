import java.util.*;
import java.io.*;

class Main_bj_2667_단지번호붙이기_대전_5반_송다경{
    static int N, num;
    static int[] aptNum;
    static int[][] grid;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        aptNum = new int[N*N];

        for(int i = 0; i<N; i++){
            String num = br.readLine();
            for(int j = 0; j<N; j++){
                grid[i][j] = num.charAt(j) - '0';
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(grid[i][j] == 1){
                    num++;
                    DFS(i, j);
                }
            }
        }

        Arrays.sort(aptNum);
        System.out.println(num);

        for(int i = 0; i< aptNum.length; i++){
            if(aptNum[i]==0) continue;
            System.out.println(aptNum[i]);
        }
    }

    static void DFS(int y, int x){
        grid[y][x] = -1;
        aptNum[num]++;

        for(int d = 0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(grid[ny][nx]==1)
                    DFS(ny, nx);
            }
        }
    }
}
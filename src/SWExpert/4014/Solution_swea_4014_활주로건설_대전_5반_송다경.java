import javax.swing.*;
import java.util.*;
import java.io.*;

public class Solution_swea_4014_활주로건설_대전_5반_송다경 {
    static int N, X, result;
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            result = 0;
            grid = new int[N][N];

            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j<N; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            rowCheck();
            colCheck();

            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }

    static void rowCheck(){
        int cnt = 0;
        next: for(int i = 0; i<N; i++){
            boolean[] v = new boolean[N];
            for(int j = 0; j<N-1; j++){
                int diff = grid[i][j] - grid[i][j+1];
                if(diff == 0) continue;
                else if(diff == -1){
                    for(int x = 1; x<X; x++){
                        if(v[j] || j-x<0 || v[j-x]) continue next;
                        if(grid[i][j-x] != grid[i][j]) continue next;
                    }
                    for(int x = 0; x<X; x++) v[j-x] = true;
                }
                else if(diff == 1){
                    for(int x = 2; x<=X; x++){
                        if(v[j+1] || j+x>=N || v[j+x]) continue next;
                        if(grid[i][j+x] != grid[i][j+1]) continue next;
                    }
                    for(int x = 1; x<=X; x++) v[j+x] = true;
                }
                else continue next;
            }
            cnt++;
        }
        result += cnt;
    }

    static void colCheck(){
        int cnt = 0;
        next: for(int j = 0; j<N; j++){
            boolean[] v = new boolean[N];
            for(int i = 0; i<N-1; i++){
                int diff = grid[i][j] - grid[i+1][j];
                if(diff == 0) continue;
                else if(diff == -1){
                    for(int x = 1; x<X; x++){
                        if(v[i] || i-x<0 || v[i-x]) continue next;
                        if(grid[i-x][j] != grid[i][j]) continue next;
                    }
                    for(int x = 0; x<X; x++) v[i-x] = true;
                }
                else if(diff == 1){
                    for(int x = 2; x<=X; x++){
                        if(v[i+1] || i+x>=N || v[i+x]) continue next;
                        if(grid[i+x][j] != grid[i+1][j]) continue next;
                    }
                    for(int x = 1; x<=X; x++) v[i+x] = true;
                }
                else continue next;
            }
            cnt++;
        }
        result += cnt;
    }
}

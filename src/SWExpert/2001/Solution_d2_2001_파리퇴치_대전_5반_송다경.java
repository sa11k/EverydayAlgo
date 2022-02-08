import java.util.Scanner;

public class Solution {
    static int getMax(int x, int y, int N, int M, int[][] grid){
        int sum = 0;
        for(int i = x; i<x+M; i++){
            for(int j = y; j <y+M; j++){
                sum+=grid[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i<T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int max = 0;

            int[][] grid = new int[N][N];
            for(int j = 0; j<N; j++){
                for(int k = 0; k<N; k++){
                    grid[j][k] = sc.nextInt();
                }
            }


            // 모든 경우의 수 구하기
            for(int j = 0; j <= N - M; j++){
                for(int k = 0; k <= N-M; k++){
                    int res = getMax(j, k, N, M, grid);
                    if(max < res)
                        max = res;
                }
            }

            System.out.println("#" + (i+1) + " " + max);
        }

    }
}

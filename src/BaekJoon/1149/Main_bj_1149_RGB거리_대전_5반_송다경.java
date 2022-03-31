import java.util.*;
import java.io.*;

public class Main_bj_1149_RGB거리_대전_5반_송다경 {
    static int N;
    static int[][] color;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new int[N+1][3];
        dp = new int[N+1][3];

        for(int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<3; j++){
                color[i][j] = Integer.parseInt(st.nextToken());
            }
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + color[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + color[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + color[i][2];
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}

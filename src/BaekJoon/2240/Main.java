import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[T+1][W+1];
        int result = 0;

        for(int t = 1; t<=T; t++) {
            int plum = Integer.parseInt(br.readLine());

            for(int w = 0; w<= W; w++) {
                // 움직임 0
                // 나무 1에서 떨어지면 1 추가 / 나무 2에서 떨어지면 X
                if(w == 0) {
                    if(plum == 1) {
                        dp[t][w] = dp[t-1][w] + 1;
                    }
                    else {
                        dp[t][w] = dp[t-1][w];
                    }
                    continue;
                }

                // 짝수 번 움직이면 자두의 위치 1
                else if (w % 2 == 0) {
                    if(plum == 1) {
                        dp[t][w] = Math.max(dp[t-1][w] + 1, dp[t-1][w-1]);
                    }
                    else {
                        dp[t][w] = Math.max(dp[t-1][w], dp[t-1][w-1] + 1);
                    }
                }

                // 홀수 번 움직이면 자두의 위치 2
                else {
                    if(plum == 1) {
                        dp[t][w] = Math.max(dp[t-1][w], dp[t-1][w-1] + 1);
                    }
                    else {
                        dp[t][w] = Math.max(dp[t-1][w] + 1, dp[t-1][w-1]);
                    }
                }
                result = Math.max(result, dp[t][w]);
            }
        }
        System.out.println(result);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] dp = new int[N+2];
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int i = 1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=N; i++) {
            max = Math.max(max, dp[i]);
            int next = i + T[i];
            if(next < N+2) {
                dp[next] = Math.max(dp[next], max + P[i]);
                ans = Math.max(ans, dp[next]);
            }
        }

        System.out.println(ans);
    }
}
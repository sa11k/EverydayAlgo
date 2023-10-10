import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] f = new int[N+1];

        for(int i = 1; i<=N; i++) f[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = f[1];

        for(int i = 2; i<=N; i++) {
            if(i == 2) dp[2] = f[1] + f[2];
            else if(i == 3) dp[3] = Math.max(f[1], f[2]) + f[3];
            else dp[i] = Math.max(dp[i-3] + f[i-1], dp[i-2]) + f[i];
        }

        System.out.println(dp[N]);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] DP = new int[N+2];
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int i = 1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<N+1; i++){
            max = Math.max(max, DP[i]);
            int next = i + T[i];
            if(next < N+2){
                DP[next] = Math.max(DP[next], max + P[i]);
                ans = Math.max(ans, DP[next]);
            }
        }
        System.out.println(ans);
    }
}


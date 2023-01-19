import java.io.*;
import java.util.*;

public class Main {
    static int N, result;
    static int[][] player;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        player = new int[N][N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        visit = new boolean[N];
        solve(0);
        System.out.println(result);
    }

    static void solve(int cnt){
        if(cnt == N){
            int start = 0;
            int link = 0;
            for(int i = 0; i<N; i++){
                for(int j = i+1; j<N; j++){
                    if(visit[i] != visit[j]) continue;
                    if (visit[i])
                        start += player[i][j] + player[j][i];
                    else
                        link += player[i][j] + player[j][i];
                }
            }
            int diff = Math.abs(start - link);
            if(diff < result) result = diff;

            return;
        }

        visit[cnt] = true;
        solve(cnt+1);
        visit[cnt] = false;
        solve(cnt+1);
    }
}
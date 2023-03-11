import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[M];
        select(0);
        System.out.println(sb);
    }

    static void select(int cnt) {
        if(cnt == M) {
            for(int i = 0; i<M; i++) sb.append(num[i]).append(" ");
            sb.append("\n");
            return;
        }
        for(int i = 1; i<=N; i++) {
            num[cnt] = i;
            select(cnt+1);
        }
    }
}
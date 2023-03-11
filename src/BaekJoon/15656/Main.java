import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] selectNum, givenNum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selectNum = new int[M];
        givenNum = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) givenNum[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(givenNum);

        select(0);

        System.out.println(sb);
    }

    static void select(int cnt) {
        if(cnt == M) {
            for(int i = 0; i<M; i++) sb.append(selectNum[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i<N; i++) {
            selectNum[cnt] = givenNum[i];
            select(cnt+1);
        }
    }
}
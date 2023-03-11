import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static boolean[] isSelected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[M];

        combination(0, 1);
    }

    static void combination(int cnt, int start) {
        if(cnt == M) {
            for(int i = 0; i<M; i++) System.out.print(num[i] + " ");
            System.out.println();
            return;
        }
        for(int i = start; i<=N; i++) {
            num[cnt] = i;
            combination(cnt+1, i+1);
        }
    }
}
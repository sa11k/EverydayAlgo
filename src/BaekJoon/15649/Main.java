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

        isSelected = new boolean[N+1];
        num = new int[M];

        permutation(0);
    }

    static void permutation(int cnt) {
        if(cnt == M) {
            for(int i = 0; i<M; i++) System.out.print(num[i] + " ");
            System.out.println();
            return;
        }
        for(int i = 1; i<=N; i++) {
            if(isSelected[i]) continue;
            num[cnt] = i;
            isSelected[i] = true;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }
}
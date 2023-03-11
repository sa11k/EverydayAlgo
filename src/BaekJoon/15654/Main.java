import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] selectNum, givenNum;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selectNum = new int[M];
        givenNum = new int[N];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) givenNum[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(givenNum);

        permutation(0);

        System.out.println(sb);
    }

    static void permutation(int cnt) {
        if(cnt == M) {
            for(int i = 0; i<M; i++) sb.append(selectNum[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i<N; i++) {
            if(isSelected[i]) continue;

            selectNum[cnt] = givenNum[i];
            isSelected[i] = true;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int[] givenNum, selectNum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if(k == 0) break;

            givenNum = new int[k];
            selectNum = new int[6];

            for(int i = 0; i<k; i++) givenNum[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(givenNum);

            select(0, 0);

            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void select(int cnt, int start) {
        if(cnt == 6) {
            for(int i = 0; i<6; i++) sb.append(selectNum[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = start; i<k; i++) {
            selectNum[cnt] = givenNum[i];
            select(cnt+1, i+1);
        }
    }
}
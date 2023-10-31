import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] isBroken = new boolean[10];

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++) {
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }


        int result = Math.abs(N - 100);
        for(int i = 0; i<=999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0; j<len; j++) {
                if(isBroken[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak) {
                int min = len + Math.abs(N - i);
                result = Math.min(min, result);
            }
        }

        System.out.println(result);
    }
}
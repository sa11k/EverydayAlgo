import java.io.*;
import java.util.*;

public class Main {
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long result = A;

        AtoB(result, B, cnt);

        if(ans != Integer.MAX_VALUE) System.out.println(ans);
        else System.out.println(-1);
    }

    static void AtoB(long A, long B, int cnt) {
        if(A >= B) {
            if(ans > cnt && A == B) {
                ans = cnt + 1;
            }
            return;
        }

        AtoB(2*A, B, cnt+1);
        AtoB(10*A+1, B, cnt+1);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] staff = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            staff[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(staff);

        long left = 0;
        long right = (long)staff[0] * (long)M;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for(int i = 0; i<N; i++) {
                count += mid / (long)staff[i];
            }

            if(count >= M) right = mid - 1;
            else left = mid + 1;
        }

        System.out.println(left);
    }
}
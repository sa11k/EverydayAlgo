import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] jewels = new int[M];
        long result = 0;

        for(int i = 0; i<M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels);

        long left = 1;
        long right = jewels[M-1];

        while(left <= right) {
            int count = 0;
            long mid = (left + right) / 2;

            for(int i = M-1; i>=0; i--) {
                if(jewels[i] % mid == 0) count += jewels[i] / mid;
                else count += jewels[i] / mid + 1;
            }

            if(count <= N){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}


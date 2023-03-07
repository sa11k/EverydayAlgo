import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) weight[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(weight);

        if(weight[0] != 1) System.out.println(1);
        else {
            result = weight[0];

            for(int i = 1; i<N; i++) {
                if(weight[i] > result + 1) {
                    System.out.println(result + 1);
                    System.exit(0);
                }
                result += weight[i];
            }
            System.out.println(result + 1);
        }
    }
}
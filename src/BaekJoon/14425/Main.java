import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> S = new ArrayList<>();
        int result = 0;

        for(int i = 0; i<N; i++) {
            S.add(br.readLine());
        }

        for(int i = 0; i<M; i++) {
            String check = br.readLine();

            if(S.contains(check)) result++;
        }

        System.out.println(result);
    }
}
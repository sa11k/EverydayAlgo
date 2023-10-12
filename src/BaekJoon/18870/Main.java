import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] X = new int[N];
        int[] XClone;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        XClone = X.clone();
        Arrays.sort(XClone);

        for(int i = 0; i<N; i++) {
            if(!map.containsKey(XClone[i]))
                map.put(XClone[i], count++);
        }

        for(int i = 0; i<N; i++) {
            sb.append(map.get(X[i])).append(" ");
        }

        System.out.println(sb);

    }
}
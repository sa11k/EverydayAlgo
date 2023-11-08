import java.io.*;
import java.util.*;

public class Main {
    static int N, K, M;
    static ArrayList<Integer> num = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i<=N; i++) num.add(i);

        Josephus(-1);

        System.out.println(sb.toString());
    }

    static void Josephus(int idx) {
        int cnt = 0;

        while (!num.isEmpty()) {
            for(int i = 0; i<K; i++) {
                idx++;
                if(idx >= num.size()) idx = 0;
            }
            sb.append(num.get(idx)).append("\n");
            num.remove(idx);
            cnt++;

            if(cnt == M) JosephusReverse(idx);

            idx--;
        }
    }

    static void JosephusReverse(int idx) {
        int cnt = 0;

        while (!num.isEmpty()) {
            for(int i = 0; i<K; i++) {
                idx--;
                if(idx < 0) idx = num.size()-1;
            }
            sb.append(num.get(idx)).append("\n");
            num.remove(idx);
            cnt++;

            if(cnt == M) Josephus(idx-1);
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i = 1; i<=N; i++) parent[i] = i;

        for(int i = 1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++) {
                int connection = Integer.parseInt(st.nextToken());
                if(connection == 1) union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for(int i = 1; i<M; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(start != find(now)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x<y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
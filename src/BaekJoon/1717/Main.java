import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 1; i<=n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int how = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(how == 0) union(a, b);
            else if(how == 1) sb.append((find(a) == find(b) ? "YES" : "NO")).append("\n");
            else continue;
        }

        System.out.println(sb);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            if(a < b) parent[b] = a;
            else parent[a] = b;
        }
    }
}
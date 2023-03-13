import java.util.*;
import java.io.*;

public class Main {
    static int N, S, E, M, ans = -1;
    static boolean[] visit;
    static int[] result;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        visit = new boolean[N+1];
        list = new List[N+1];
        result = new int[N+1];

        for(int i = 1; i<=N; i++) list[i] = new ArrayList<>();

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int up = Integer.parseInt(st.nextToken());
            int down = Integer.parseInt(st.nextToken());

            list[up].add(down);
            list[down].add(up);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        result[S] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if(now == E) {
                ans = result[now];
                break;
            }

            if(!visit[now]) visit[now] = true;
            for(int i = 0; i<list[now].size(); i++) {
                int next = list[now].get(i);
                if(!visit[next]) {
                    queue.add(next);
                    result[next] = result[now] + 1;
                }
            }
        }

        System.out.println(ans);
    }
}
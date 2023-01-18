import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static Queue<Integer> queue;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue = new ArrayDeque<>();

        for(int i = 1; i<=N; i++){
            queue.add(i);
        }

        sb.append("<");

        solution();

        sb.delete(sb.length()-2, sb.length()).append(">");

        System.out.println(sb);
    }

    static void solution(){
        while (!queue.isEmpty()){
            for(int i = 0; i<K-1; i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll()+", ");
        }
    }
}
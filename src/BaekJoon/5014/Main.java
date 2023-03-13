import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D, result;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[F+1];

        result = goElevator();

        if(result == 0) System.out.println("use the stairs");
        else System.out.println(arr[result] - 1);
    }

    static int goElevator() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        arr[S] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if(now == G) return now;

            if(now + U <= F && arr[now + U] == 0) {
                arr[now + U] = arr[now] + 1;
                queue.add(now + U);
            }

            if(now - D > 0 && arr[now - D] == 0) {
                arr[now - D] = arr[now] + 1;
                queue.add(now - D);
            }
        }

        return 0;
    }
}
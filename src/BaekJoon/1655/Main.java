import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> min = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> max = new PriorityQueue<>();

        for(int i = 0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(min.size() == max.size()) min.add(num);
            else max.add(num);

            if(!min.isEmpty() && !max.isEmpty()) {
                if(max.peek() < min.peek()) {
                    int tmp = max.poll();
                    max.add(min.poll());
                    min.add(tmp);
                }
            }

            sb.append(min.peek()).append("\n");
        }
        System.out.println(sb);
    }
}


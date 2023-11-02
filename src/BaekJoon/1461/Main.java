import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int result = 0;

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(max < Math.abs(num)) max = Math.abs(num);

            if(num > 0) pos.add(num);
            else neg.add(Math.abs(num));
        }

        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg, Collections.reverseOrder());

        for(int i = 0; i<pos.size(); i++) {
            if(i % M == 0 && pos.get(i) == max) result += pos.get(i);
            else if(i % M == 0) result += (pos.get(i) * 2);
        }

        for(int i = 0; i<neg.size(); i++) {
            if(i % M == 0 && neg.get(i) == max) result += neg.get(i);
            else if(i % M == 0) result += (neg.get(i) * 2);
        }

        System.out.println(result);
    }
}
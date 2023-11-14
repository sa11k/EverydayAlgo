import java.io.*;
import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N <= 10) System.out.println(N);
        else {
            for(int i = 0; i<10; i++) {
                countNum((long)i);
            }

            Collections.sort(list);

            if(list.size() <= N) System.out.println(-1);
            else System.out.println(list.get(N));
        }
    }

    static void countNum(long num) {
        if(num > Long.parseLong("9876543210")) return;

        list.add(num);

        for(int i = 0; i<10; i++) {
            if(num % 10 > i) countNum((num * 10) + (long)i);
        }
    }
}
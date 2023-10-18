import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        sb = new StringBuilder();

        perm(0, "");
        System.out.println(sb.toString());
    }

    public static void perm(int cnt, String num) {
        if(cnt == N) {
            sb.append(num).append("\n");
            return;
        }

        for(int i = 0; i<=9; i++) {
            if(isPrime(Integer.parseInt(num+i))) {
                perm(cnt+1, num+i);
            }
        }
    }

    public static boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i*i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
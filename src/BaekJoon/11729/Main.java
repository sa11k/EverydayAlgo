import java.io.*;
import java.util.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }

    static void hanoi(int n, int from, int mid, int to){
        count++;
        if(n == 1){
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n-1, from, to, mid);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n-1, mid, from, to);
    }
}
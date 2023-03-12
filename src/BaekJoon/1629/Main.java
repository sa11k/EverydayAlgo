import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(cal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    static long cal(int A, int B, int C) {
        if(B == 0) return 1;

        long n = cal(A, B/2, C);
        if(B % 2 == 0) return n * n % C;
        else return (n*n%C) * A % C;
    }
}
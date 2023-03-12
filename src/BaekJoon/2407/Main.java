import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BigInteger sum = BigInteger.ONE;
        BigInteger div = BigInteger.ONE;

        for(int i = 0; i<M; i++) {
            sum = sum.multiply(new BigInteger(String.valueOf(N-i)));
            div = div.multiply(new BigInteger(String.valueOf(i+1)));
        }

        System.out.println(sum.divide(div));
    }
}
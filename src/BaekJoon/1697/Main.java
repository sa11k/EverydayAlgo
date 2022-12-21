import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 1;
        int count = 1;
        boolean[] check = new boolean[100001];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        check[N] = true;

        if(N == K){
            System.out.println(0);
            System.exit(0);
        }

        go : while(!queue.isEmpty()){
            int repeat = count;
            count = 0;
            for(int i = 0; i<repeat; i++){
                int now = queue.poll();
                int minus1 = now-1;
                int plus1 = now+1;
                int mul2 = 2*now;

                if(check(minus1) && !check[minus1]){
                    check[minus1] = true;
                    queue.add(minus1);
                    count++;
                }
                if(check(plus1) && !check[plus1]){
                    check[plus1] = true;
                    queue.add(plus1);
                    count++;
                }
                if(check(mul2) && !check[mul2]){
                    check[mul2] = true;
                    queue.add(mul2);
                    count++;
                }

                if(minus1 == K || plus1 == K || mul2 == K) {
                    break go;
                }
            }
            result++;
        }
        System.out.println(result);
    }

    public static boolean check(int n){
        return n>=0 && n<=100000;
    }
}
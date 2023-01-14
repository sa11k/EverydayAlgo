import java.io.*;
import java.util.*;

public class Main {
    static int N, K, result = 0;
    static int[] fitness, order;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        fitness = new int[N];
        order = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            fitness[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0, new boolean[N]);

        System.out.println(result);
    }

    static void permutation(int cnt, boolean[] isChecked){
        if(cnt == N){
            int weight = 500;

            for(int i = 0; i<N; i++){
                weight -= K;
                weight += order[i];
                if(weight < 500) return;
            }

            result++;
        }

        for(int i = 0; i<N; i++){
            if(isChecked[i]) continue;

            order[cnt] = fitness[i];
            isChecked[i] = true;
            permutation(cnt + 1, isChecked);
            isChecked[i] = false;
        }
    }
}
import java.io.*;
import java.util.*;

public class Main_bj_2961_도영이가만든맛있는음식_대전_5반_송다경 {
    static int N;
    static int minResult;
    static int[][] flavor;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        minResult = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        flavor = new int[N][2];     // 0 : 신맛, 1 : 쓴맛

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            flavor[i][0] = Integer.parseInt(st.nextToken());
            flavor[i][1] = Integer.parseInt(st.nextToken());
        }

        subset(0, new boolean[N]);

        System.out.println(minResult);
    }

    static void subset(int cnt, boolean[] isSelected){
        if(cnt == N){
            int mul = 1;    // 신맛 곱하기
            int sum = 0;    // 쓴맛 더하기
            int result = 0;
            int count = 0;
            for(int i = 0; i<N; i++){
                if(isSelected[i]){
                    count++;
                    mul*=flavor[i][0];
                    sum+=flavor[i][1];
                }
            }
            if(count==0)return;
            result = Math.abs(mul-sum);

            if(minResult>result) minResult = result;
            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1, isSelected);
        isSelected[cnt] = false;
        subset(cnt+1, isSelected);
    }
}

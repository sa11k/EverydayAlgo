import java.util.*;
import java.io.*;

public class Solution_d3_6808_규영이와인영이의카드게임_대전_5반_송다경 {
    static int resultWin, resultLose;
    static int[] K, I, result;
    static boolean[] check;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++){
            resultWin = 0;
            resultLose = 0;
            K = new int[9];
            I = new int[9];
            check = new boolean[18];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i<9; i++){
                K[i] = Integer.parseInt(st.nextToken());
                check[K[i]-1] = true;
            }

            int idx = 0;
            for(int i = 0; i<18; i++){
                if(!check[i]){
                    I[idx++] = i+1;
                }
            }

            result = new int[9];
            perm(0, new boolean[9]);

            System.out.println("#"+tc+" "+resultWin +" "+resultLose);

        }
        br.close();
    }

    static void perm(int cnt, boolean[] isSelected){
        if(cnt==9){
            int ku = 0;
            int in = 0;

            for(int i = 0; i<9; i++){
                if(K[i]>result[i]) ku += K[i]+result[i];
                else if(K[i]<result[i]) in += K[i]+result[i];
            }
            if(ku>in) resultWin++;
            else if(ku<in) resultLose++;
            return;
        }

        for(int i = 0; i<9; i++){
            if(isSelected[i]) continue;
            result[cnt] = I[i];
            isSelected[i] = true;
            perm(cnt+1, isSelected);
            isSelected[i] = false;
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] S;
    static boolean[] isChecked;
    static ArrayList<Integer> num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        isChecked = new boolean[N];
        num = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);

        Collections.sort(num);

        setResultCheck();
    }
    static void subset(int cnt){
        if(cnt == N){
            int result = 0;
            for(int i = 0; i<N; i++){
                if(isChecked[i]) result += S[i];
            }
            num.add(result);
            return;
        }

        isChecked[cnt] = true;
        subset(cnt+1);
        isChecked[cnt] = false;
        subset(cnt+1);

    }

    static void setResultCheck(){
        boolean[] check = new boolean[num.get(num.size()-1)+1];
        for(int i = 0; i<num.size(); i++){
            check[num.get(i)] = true;
        }
        for(int i = 0; i<check.length; i++){
            if(!check[i]){
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(check.length);
        System.exit(0);
    }
}
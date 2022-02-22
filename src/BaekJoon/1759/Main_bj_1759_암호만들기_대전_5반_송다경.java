import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_1759_암호만들기_대전_5반_송다경 {
    static int L, C;
    static char[] chars, result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        result = new char[L];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<C; i++){
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);

        com(0, 0, 0, 0);

    }

    public static void com(int cnt, int start, int v, int c){
        if(cnt == L){
            if(v >= 1 && c >= 2){
                for(int i = 0; i<L; i++){
                    System.out.print(result[i]);
                }
                System.out.println();
            }
            return;
        }

        for(int i = start; i<C; i++){
            result[cnt] = chars[i];

            if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u')
                com(cnt+1, i+1, v+1, c);
            else
                com(cnt+1, i+1, v, c+1);
        }
    }
}
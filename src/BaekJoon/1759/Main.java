import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] givenChar, selectChar;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        givenChar = new char[C];
        selectChar = new char[L];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<C; i++) givenChar[i] = st.nextToken().charAt(0);

        Arrays.sort(givenChar);

        code(0, 0);
    }

    static void code(int cnt, int start) {
        if(cnt == L) {
            if(isRight()) System.out.println(selectChar);
            return;
        }

        for(int i = start; i<C; i++) {
            selectChar[cnt] = givenChar[i];
            code(cnt+1, i+1);
        }
    }

    static boolean isRight() {
        int aeiou = 0;
        int another = 0;

        for(char c : selectChar) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') aeiou++;
            else another++;
        }

        if(aeiou >= 1 && another >= 2) return true;
        else return false;
    }
}
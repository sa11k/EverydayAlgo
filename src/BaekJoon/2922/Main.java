import java.io.*;
import java.util.*;

public class Main {
    static String input;
    static char[] word = new char[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        for(int i = 0; i<input.length(); i++) {
            if(checkAEIOU(input.charAt(i))) word[i] = 'V';
            else if(input.charAt(i) != '_' && input.charAt(i) != 'L') word[i] = 'C';
            else word[i] = input.charAt(i);
        }
        System.out.println(makeWord(0));
    }

    static boolean checkAEIOU(char c) {
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        else return false;
    }

    static long makeWord(int index) {
        while (true) {
            if(index == word.length-1) {
                int c = 0;
                int v = 0;
                boolean l = false;

                for(int i = 0; i<index; i++) {
                    if(word[i] == 'C' || word[i] == 'L') {
                        c++;
                        v = 0;
                        if(word[i] == 'L') l = true;
                    }
                    else if(word[i] == 'V') {
                        v++;
                        c = 0;
                    }

                    if(c >= 3 || v >= 3) return 0;
                }
                if(l == true) return 1;
                else return 0;
            }
            if(word[index] == '_') {
                long result = 0;
                word[index] = 'C'; result += 20 * makeWord(index + 1);
                word[index] = 'V'; result += 5 * makeWord(index + 1);
                word[index] = 'L'; result += makeWord(index + 1);
                word[index] = '_';
                return result;
            }
            index++;
        }
    }
}
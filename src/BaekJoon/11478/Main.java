import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Set<String> set = new HashSet<>();

        for(int i = 0; i<str.length(); i++) {
            for(int j = i + 1; j<=str.length(); j++) {
                set.add(str.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}
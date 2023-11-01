import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        int result = 0;

        String str;
        Set<String> set = new HashSet<>();

        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");

            String time = st.nextToken();
            String name = st.nextToken();

            if(time.compareTo(S) <= 0) set.add(name);
            else if(time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
                if(set.contains(name)) {
                    result++;
                    set.remove(name);
                }
            }
        }

        System.out.println(result);
    }
}
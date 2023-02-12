import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T; tc++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treemap = new TreeMap<>();

            for(int i = 0; i<k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if(st.nextToken().equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    treemap.put(num, treemap.getOrDefault(num, 0) + 1);
                } else {
                    int num = Integer.parseInt(st.nextToken());
                    if(num == 1) {
                        if(treemap.size() == 0) continue;
                        int value = treemap.get(treemap.lastKey());
                        if(value == 1) treemap.remove(treemap.lastKey());
                        else treemap.put(treemap.lastKey(), value-1);
                    } else {
                        if(treemap.size() == 0) continue;
                        int value = treemap.get(treemap.firstKey());
                        if(value == 1) treemap.remove(treemap.firstKey());
                        else treemap.put(treemap.firstKey(), value-1);
                    }
                }
            }
            if(treemap.size() == 0) System.out.println("EMPTY");
            else System.out.println(treemap.lastKey() + " " + treemap.firstKey());
        }
    }
}
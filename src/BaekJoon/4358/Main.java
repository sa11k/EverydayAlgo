import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> trees = new HashMap<>();
        String tree;
        int total = 0;

        while ((tree = br.readLine()) != null) {
            total++;
            if(trees.containsKey(tree)) {
                trees.put(tree, trees.get(tree) + 1);
            }
            else {
                trees.put(tree, 1);
            }
        }

        List<String> map2list = new ArrayList<>(trees.keySet());
        Collections.sort(map2list);

        for(String key : map2list) {
            double percent = trees.get(key)*100 / (double) total;
            sb.append(key).append(" ").append(String.format("%.4f", percent)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
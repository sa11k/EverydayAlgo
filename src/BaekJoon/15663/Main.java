import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] selectNum, givenNum;
    static boolean[] isSelected;
    static Set<String> nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new LinkedHashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selectNum = new int[M];
        givenNum = new int[N];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) givenNum[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(givenNum);

        permutation(0);

        Iterator iter = nums.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    static void permutation(int cnt) {
        if(cnt == M) {
            String s = "";
            for(int i = 0; i<M; i++) s += selectNum[i] + " ";
            nums.add(s);
            return;
        }

        for(int i = 0; i<N; i++) {
            if(isSelected[i]) continue;

            selectNum[cnt] = givenNum[i];
            isSelected[i] = true;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }
}
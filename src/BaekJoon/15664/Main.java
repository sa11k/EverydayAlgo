import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] givenNum, selectNum;
    static Set<String> nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        givenNum = new int[N];
        selectNum = new int[M];

        nums = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) givenNum[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(givenNum);

        select(0, 0);

        Iterator iterator = nums.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    static void select(int cnt, int start) {
        if(cnt == M) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<M; i++) sb.append(selectNum[i]).append(" ");
            nums.add(sb + "");
            return;
        }

        for(int i = start; i<N; i++) {
            selectNum[cnt] = givenNum[i];
            select(cnt+1, i+1);
        }
    }
}
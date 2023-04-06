import java.io.*;
import java.util.*;

class home {
    int i;
    int j;
    int d;

    public home(int i, int j, int d) {
        this.i = i;
        this.j = j;
        this.d = d;
    }
}

class chicken {
    int i;
    int j;

    public chicken(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int N, M, result = Integer.MAX_VALUE;
    static List<home> homeList = new ArrayList<>();
    static List<chicken> chickenList = new ArrayList<>();
    static chicken[] selectChickenList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selectChickenList = new chicken[M];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                int now = Integer.parseInt(st.nextToken());
                if(now == 1) homeList.add(new home(i, j, Integer.MAX_VALUE));
                else if(now == 2) chickenList.add(new chicken(i, j));
            }
        }

        selectChicken(0, 0);

        System.out.println(result);
    }

    static void selectChicken(int cnt, int start) {
        if(cnt == M) {
            int sum = 0;
            for(int i = 0; i<homeList.size(); i++) homeList.get(i).d = Integer.MAX_VALUE;
            for(int i = 0; i<homeList.size(); i++) {
                home now = homeList.get(i);

                for(int j = 0; j<M; j++) {
                    chicken nowChicken = selectChickenList[j];
                    int diff = Math.abs(now.i - nowChicken.i) + Math.abs(now.j - nowChicken.j);

                    if(now.d > diff) {
                        homeList.get(i).d = diff;
                    }
                }
            }

            for(int i = 0; i<homeList.size(); i++) {
                sum += homeList.get(i).d;
            }

            if(result > sum) result = sum;

            return;
        }

        for(int i = start; i<chickenList.size(); i++) {
            selectChickenList[cnt] = chickenList.get(i);
            selectChicken(cnt+1, i+1);
        }
    }
}
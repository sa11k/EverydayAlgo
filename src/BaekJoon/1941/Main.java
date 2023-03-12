import java.io.*;
import java.util.*;

public class Main {
    static char[][] students = new char[5][5];
    static int[] selected = new int[7];
    static boolean[][] selectStudents = new boolean[5][5];
    static int result = 0;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i<5; i++) students[i] = br.readLine().toCharArray();

        select(0, 0, 0);
        System.out.println(result);
    }

    static void select(int cnt, int start, int som) {
        if(cnt == 7) {
            if(som >= 4) {
                if(check()) result++;
                return;
            }
            return;
        }

        for(int i = start; i<25; i++) {
            selectStudents[i/5][i%5] = true;
            selected[cnt] = i;
            if(students[i/5][i%5] == 'S') select(cnt+1, i+1, som+1);
            else select(cnt+1, i+1, som);
            selectStudents[i/5][i%5] = false;
        }
    }

    static boolean check() {
        int cnt = 1;
        boolean[][] visited = new boolean[5][5];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(selected[0]);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now/5][now%5] = true;

            for(int d = 0; d<4; d++) {
                int ni = (now/5) + di[d];
                int nj = (now%5) + dj[d];

                if(ni < 0 || nj < 0 || ni >= 5 || nj >= 5) continue;
                if(visited[ni][nj]) continue;
                if(!selectStudents[ni][nj]) continue;

                cnt++;
                visited[ni][nj] = true;
                queue.add(ni*5+nj);
            }
        }

        return cnt == 7;
    }
}
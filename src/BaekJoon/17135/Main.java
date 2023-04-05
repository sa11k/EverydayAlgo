import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D, result;
    static int[][] map;
    static int[] selectedCastle = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selectCastle(0, 0);

        System.out.println(result);
    }

    static void selectCastle(int cnt, int start) {
        if(cnt == 3) {
            defense();
            return;
        }

        for(int i = start; i<M; i++) {
            selectedCastle[cnt] = i;
            selectCastle(cnt+1, i+1);
        }
    }

    static void defense() {
        int tmp = 0;
        int castle = N;
        int[][] tmpMap = new int[N][M];

        for(int i = 0; i<N; i++) {
            System.arraycopy(map[i], 0, tmpMap[i], 0, M);
        }

        while (castle > 0) {
            List<Integer[]> enemy = new ArrayList<>();

            for(int k = 0; k<3; k++) {
                int min = Integer.MAX_VALUE;
                int[] enemyPos = new int[2];

                for(int j = 0; j<M; j++) {
                    for(int i = castle-1; i>=0; i--) {
                        int diff = Math.abs(castle-i) + Math.abs(selectedCastle[k]-j);

                        if(tmpMap[i][j] == 1 && diff <= D) {
                            if(diff < min) {
                                min = diff;
                                enemyPos[0] = i;
                                enemyPos[1] = j;
                            }
                            break;
                        }
                    }
                }

                if(min != Integer.MAX_VALUE) enemy.add(new Integer[] {enemyPos[0], enemyPos[1]});
            }

            for(int i = 0; i<enemy.size(); i++) {
                if(tmpMap[enemy.get(i)[0]][enemy.get(i)[1]] != 0) {
                    tmp += 1;
                    tmpMap[enemy.get(i)[0]][enemy.get(i)[1]] = 0;
                }
            }

            castle -= 1;
        }

        if(tmp > result) result = tmp;
    }
}
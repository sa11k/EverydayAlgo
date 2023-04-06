import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static List<int[]> airCleaner;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        airCleaner = new ArrayList<>();

        for(int i = 0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) airCleaner.add(new int[] {i, j});
            }
        }

        for(int i = 0; i<T; i++) spread();

        System.out.println(count());
    }

    static void spread() {
        int[][] spreadMap = new int[R][C];

        for(int i = 0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                if(map[i][j] != 0) {
                    int amount = map[i][j]/5;
                    int cnt = 0;

                    for(int d = 0; d<4; d++) {
                        int ni = i + di[d];
                        int nj = j + dj[d];

                        if(ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] != -1) {
                            cnt++;
                            spreadMap[ni][nj] += amount;
                        }
                    }

                    spreadMap[i][j] += map[i][j] - (amount * cnt);
                }
            }
        }

        // 위쪽 공기청정기
        int topAirCleanerI = airCleaner.get(0)[0];
        int topAirCleanerJ = airCleaner.get(0)[1];

        // 아래쪽 공기청정기
        int bottomAirCleanerI = airCleaner.get(1)[0];
        int bottomAirCleanerJ = airCleaner.get(1)[1];

        // 위쪽 공기청정기 작동
        for(int i = topAirCleanerI-1; i>=0; i--) spreadMap[i+1][topAirCleanerJ] = spreadMap[i][topAirCleanerJ];
        for(int j = 1; j<C; j++) spreadMap[0][j-1] = spreadMap[0][j];
        for(int i = 1; i<=topAirCleanerI; i++) spreadMap[i-1][C-1] = spreadMap[i][C-1];
        for(int j = C-2; j>0; j--) spreadMap[topAirCleanerI][j+1] = spreadMap[topAirCleanerI][j];

        spreadMap[topAirCleanerI][topAirCleanerJ+1] = 0;
        spreadMap[topAirCleanerI][topAirCleanerJ] = -1;

        // 아래쪽 공기청정기 작동
        for(int i = bottomAirCleanerI+1; i<R; i++) spreadMap[i-1][bottomAirCleanerJ] = spreadMap[i][bottomAirCleanerJ];
        for(int j = 1; j<C; j++) spreadMap[R-1][j-1] = spreadMap[R-1][j];
        for(int i = R-2; i>=bottomAirCleanerI; i--) spreadMap[i+1][C-1] = spreadMap[i][C-1];
        for(int j = C-2; j>0; j--) spreadMap[bottomAirCleanerI][j+1] = spreadMap[bottomAirCleanerI][j];

        spreadMap[bottomAirCleanerI][bottomAirCleanerJ+1] = 0;
        spreadMap[bottomAirCleanerI][bottomAirCleanerJ] = -1;

        for(int i = 0; i<R; i++) System.arraycopy(spreadMap[i], 0, map[i], 0, C);
    }

    static int count() {
        int cnt = 0;

        for(int i = 0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                if(map[i][j] != -1) cnt += map[i][j];
            }
        }

        return cnt;
    }
}
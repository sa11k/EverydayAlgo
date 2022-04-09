import java.util.*;
import java.io.*;

public class Solution_d5_7793_오나의여신님_대전_5반_송다경 {
    static int N, M, result;            // 행, 열, 시간
    static char[][] grid;               // 지도
    static boolean[][][] visit;         // 각각 방문을 표시해주기 위해서 3차원으로 함 [행][열][악마/수연]
    static Deque<int[]> devil, su;      // 악마 큐, 수연 큐
    static int[] dx = {1, -1, 0, 0};    // 동 서 남 북
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            result = -1;
            devil = new ArrayDeque<>();
            su = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            grid = new char[N][M];
            visit = new boolean[N][M][2];   // 0: 악마 , 1: 수연

            for(int i = 0; i<N; i++){
                String s = br.readLine();
                for(int j = 0; j<M; j++){
                    grid[i][j] = s.charAt(j);
                    // 악마와 수연이가 있는 위치 각각을 큐에 저장함
                    // 악마
                    if(grid[i][j] == '*'){
                        visit[i][j][0] = true;
                        devil.offer(new int[] {i, j});
                    }
                    // 수연
                    if(grid[i][j] == 'S'){
                        visit[i][j][1] = true;
                        su.offer(new int[] {i, j});
                    }
                }
            }

            goSafe();

            System.out.println("#" + tc + " " + (result==-1 ? "GAME OVER" : result));
        }

        br.close();
    }

    static void goSafe(){
        int cnt = 0;
        stop : while(true){
            int dSize = devil.size();
            int sSize = su.size();
            // 수연이 큐가 다 비었을 때
            if(sSize == 0)
                break;

            // 악마
            while (dSize-- > 0){
                int[] xy = devil.poll();    // [0]: y, [1]: x
                for(int d = 0; d<4; d++){
                    int nx = xy[1] + dx[d];
                    int ny = xy[0] + dy[d];
                    // 범위를 벗어나거나 여신님, 돌이 있거나 방문했던 곳으로는 이동할 수 없음
                    if(nx<0 || nx>=M || ny<0 || ny>=N
                            || grid[ny][nx] == 'D' || visit[ny][nx][0] || grid[ny][nx] == 'X')  continue;
                    // 이동
                    visit[ny][nx][0] = true;
                    grid[ny][nx] = '*';
                    devil.offer(new int[] {ny, nx});
                }
            }

            // 수연
            while(sSize-- > 0){
                int[] xy = su.poll();
                // 여신을 만났을 때
                if(grid[xy[0]][xy[1]] == 'D') {
                    result = cnt;
                    break stop;
                }
                for(int d = 0; d<4; d++){
                    int nx = xy[1] + dx[d];
                    int ny = xy[0] + dy[d];
                    // 범위를 벗어나거나 악마, 돌이 있거나 방문했던 곳으로는 이동할 수 없음
                    if(nx<0 || nx>=M || ny<0 || ny>=N
                            || grid[ny][nx] == '*' || visit[ny][nx][1] || grid[ny][nx] == 'X') continue;
                    // 이동
                    visit[ny][nx][1] = true;
                    su.offer(new int[] {ny, nx});
                }
            }

            cnt++;

        }
    }
}

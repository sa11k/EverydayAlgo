import java.io.*;
import java.util.*;

public class Main_bj_16926_배열돌리기1_대전_5반_송다경 {
	
	static int N,M,R;
	static int[][] grid;
	static boolean[][] visit;
	
	static int[] dx = {1, 0, -1, 0};	// 우 하 좌 상
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 행의 개수
		M = Integer.parseInt(st.nextToken());	// 열의 개수
		R = Integer.parseInt(st.nextToken());	// 회전 횟수
		
		grid = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int level = Math.min(N, M)/2;
		
		for(int i = 0; i<level; i++) {
			for(int j = 0; j<R; j++) {
				Rotation(i);
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void Rotation(int num) {
		int tmp = grid[num][num];
		int x = num, y = num;
		
		int idx = 0;
		
		while(idx<4) {
			int nx = x + dx[idx];
			int ny = y + dy[idx];
			
			if(nx>=num && ny>=num && nx<M-num && ny<N-num) {
				grid[y][x] = grid[ny][nx];
				x = nx;
				y = ny;
			}else {
				idx++;
			}
		}
		grid[num+1][num] = tmp;
	}
}

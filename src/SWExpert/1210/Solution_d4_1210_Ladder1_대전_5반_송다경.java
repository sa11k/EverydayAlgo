import java.io.*;
import java.util.*;

public class Solution_d4_1210_Ladder1_대전_5반_송다경 {
	static int[][] grid;
	static boolean[][] visit;
	static int res = 0;
	static int find[] = new int[2];
	static int dx[] = {0, 0};
	static int dy[] = {-1, 1};
	static int dir[];
	
	public static void find(int x, int y) {
		if(x==0) {
			res = y;
			return;
		}
		
		visit[x][y] = true;
		dir = new int[] {-1, 0};
		
		for(int i = 0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 100 || nx <0 || ny >= 100 || ny <0) continue;
			
			if(grid[nx][ny]==0) continue;
			
			if(visit[nx][ny]) continue;
			
			dir = new int[] {dx[i], dy[i]};
		}
		find(x+dir[0], y+dir[1]);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc<=10; tc++) {
			tc = sc.nextInt();
			
			grid = new int[100][100];
			visit = new boolean[100][100];
			
			for(int i = 0; i<100; i++) {
				for(int j = 0; j<100; j++) {
					grid[i][j] = sc.nextInt();
					if(grid[i][j] == 2) {
						find = new int[] {i, j};
					}
				}
			}
			find(find[0], find[1]);
			System.out.println("#"+tc+" "+res);
		}
	}

}

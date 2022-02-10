import java.io.*;
import java.util.*;

public class Main_bj_2563_색종이_대전_5반_송다경 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] paper = new int[100][100];
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for(int tc = 0; tc<N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = y; i<y+10; i++) {
				for(int j = x; j<x+10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(paper[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}

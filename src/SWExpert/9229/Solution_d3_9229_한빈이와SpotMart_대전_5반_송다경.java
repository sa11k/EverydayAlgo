import java.io.*;
import java.util.*;

public class Solution_d3_9229_한빈이와SpotMart_대전_5반_송다경 {
	static int max, N, snack[], input[], M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=tc; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st1.nextToken());
			snack = new int[2];
			input = new int[N];
			M = Integer.parseInt(st1.nextToken());
			st1 = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				input[j] = Integer.parseInt(st1.nextToken());
			}
			
			com(0, 0);
			
			if(max == 0) {
				max = -1;
			}
			
			System.out.println("#"+i+" "+max);
			max = 0;
		}
		
	}
	
	public static void com(int cnt, int start) {
		if(cnt == 2) {
			int sum = 0;
			for(int i = 0; i<2; i++) {
				sum += snack[i];
			}
			
			if(max<sum && sum<=M) {
				max = sum;
			}
			return;
		}
		for(int i = start; i<N; i++) {
			snack[cnt] = input[i];
			com(cnt+1, i+1);
		}
	}
}

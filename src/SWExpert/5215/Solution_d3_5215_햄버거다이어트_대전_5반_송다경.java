import java.util.Scanner;

public class Solution_d3_5215_햄버거다이어트_대전_5반_송다경 {
	static int N, L, result, hambuger[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(sc.next());
			L = Integer.parseInt(sc.next());
			result = 0;
			hambuger = new int[N][2];
			
			for(int i = 0; i<N; i++) {
				hambuger[i][0] = Integer.parseInt(sc.next());
				hambuger[i][1] = Integer.parseInt(sc.next());
			}
			
			select(0, 0, 0);
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	public static void select(int cnt, int sumScore, int sumCal) {
		if(sumCal>L) return;
		
		if(cnt == N) {
			result = Math.max(result, sumScore);
			return;
		}
		
		select(cnt+1, sumScore+hambuger[cnt][0], sumCal+hambuger[cnt][1]);
		
		select(cnt+1, sumScore, sumCal);
	}

}

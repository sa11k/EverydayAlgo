import java.util.Scanner;

public class Solution_d2_1954_달팽이숫자_대전_5반_송다경 {
	static int N, stop;
	static int[][] arr;
	static boolean[][] visit;
	
	static void Snail(int k, int k2, int cnt) {
		if (cnt > stop)
			return;
		
		for (int i = 1; i <= N; i++) {
			if (k2 + i < N && visit[k][k2 + i] == false) {
				arr[k][k2 + i] = cnt;
				visit[k][k2 + i] = true;
				cnt++;
			} else {
				k2 = k2 + i - 1;
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (k + i < N && visit[k + i][k2] == false) {
				arr[k + i][k2] = cnt;
				visit[k + i][k2] = true;
				cnt++;
			} else {
				k = k + i - 1;
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (k2 - i >= 0 && visit[k][k2 - i] == false) {
				arr[k][k2 - i] = cnt;
				visit[k][k2 - i] = true;
				cnt++;
			} else {
				k2 = k2 - i + 1;
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (k - i >= 0 && visit[k - i][k2] == false) {
				arr[k - i][k2] = cnt;
				visit[k - i][k2] = true;
				cnt++;
			} else {
				k = k - i + 1;
				break;
			}
		}
		Snail(k, k2, cnt);
	}


	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			stop = N*N;
			arr = new int[N][N];
			visit = new boolean[N][N];
			arr[0][0]=1;
			visit[0][0]= true;
			
			Snail(0, 0, 2);
			
			System.out.printf("#%d\n", tc);

			for (int k = 0; k < N; k++) {
				for (int k2 = 0; k2 < N; k2++) {
					System.out.printf(arr[k][k2]+" ");
				}System.out.println();
			}
		}
		
	}
}

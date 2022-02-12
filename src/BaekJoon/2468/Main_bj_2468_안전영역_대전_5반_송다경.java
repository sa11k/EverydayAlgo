import java.io.*;
import java.util.*;

public class Main_bj_2468_안전영역_대전_5반_송다경 {
	 /*
	 * 1. 첫째 줄 입력 : 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수 
	 * 2. 둘째 줄 ~ 끝까지 : 높이 정보 
	 * 3. 배열에 높이 정보를 다 받아와서 저장하는데 이 과정에서 건물 높이 리스트(어떠한 높이들이 있는지, high[])를 배열에 저장해줌 
	 * 4. high 배열을 정렬하고 가장 작은 값부터 하나씩 꺼내서 그 값 이하인 건물은 1로 설정해줌(temp 배열에 저장) 
	 * 5. temp 배열에서 DFS를 돌면서 0인 경우만 탐색하여 cnt를 증가해줌 
	 * 6. 이 과정을 반복하고, 마지막에 전체가 다 잠긴 경우를 하나 더해줌 
	 * 7. cnt 출력
	 */
	static int cnt = 0; // 안전 영역의 개수
	static int max = 0;
	static ArrayDeque<Integer> h = new ArrayDeque<Integer>();
	static int[][] grid;
	static int[][] temp;
	static int[] di = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine()); // 행과 열의 개수

		grid = new int[N][N];
		temp = new int[N][N];

		// 높이 정보를 받아와 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		HeightArray(N);	// 건물들의 높이 정보들을 받아오는 메소드
		int queueSize = h.size();
		
		for(int i = 0; i<queueSize; i++) {
			cnt = 0;
			int height = h.poll();
			temp = check(N, height);	// 높이에 따라서 색칠된 배열
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<N; k++) {
					if(temp[j][k] == 0) {
						cnt+=1;
						DFS(j, k, N);
//						BFS(j, k, N);
					}
				}
			}
			max = Math.max(cnt, max);
		}
		
		
		
		System.out.println(max);

	}

	public static void HeightArray(int N) {
		Set<Integer> set = new HashSet<>();
		// 높이 정보를 중복을 제거하고 받아오기 위해 Set 사용
		for (int[] line : grid) {
			for (int num : line) {
				set.add(num);
			}
		}

		int[] high = new int[set.size()]; // 높이 정보를 저장할 배열
		Iterator<Integer> it = set.iterator();
		for (int i = 0; i < high.length; i++) {
			high[i] = it.next();
		}

		Arrays.sort(high); // 높이 정보 정렬
		
		h.offer(0);

		for (int i = 0; i < high.length; i++) { // 하나씩 꺼내쓰기 편하게 하려고 큐에 저장
			h.offer(high[i]);
		}
	}
	
	public static int[][] check(int N, int height) {
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(grid[i][j]<=height) {
					result[i][j] = 1;
				}
			}
		}
		return result;
	}
	
	static void DFS(int i, int j, int N) {
		temp[i][j] = 2;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (0 <= ni && ni < N && 0 <= nj && nj < N && temp[ni][nj] == 0) {
				DFS(ni, nj, N);
			}
		}
	}
	
	static void BFS(int i, int j, int N) {
		Queue<int[]> q = new LinkedList<>(); // ArrayDque도 가능
		temp[i][j] = 2;
		q.offer(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			i = cur[0];
			j = cur[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < N && temp[ni][nj] == 0) {
					temp[ni][nj] = 2;
					q.offer(new int[] { ni, nj });
				}
			}
		}
	}

}

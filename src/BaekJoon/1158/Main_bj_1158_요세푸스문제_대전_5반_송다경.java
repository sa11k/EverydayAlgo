import java.io.*;
import java.util.*;

public class Main_bj_1158_요세푸스문제_대전_5반_송다경 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		ArrayDeque<Integer> result = new ArrayDeque<>();
		
		for(int i = 1; i<=N; i++) {
			queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			for(int i = 1; i<=K; i++) {
				if(i==K) {
					result.offer(queue.pollFirst());
				}else {
					queue.offer(queue.pollFirst());
				}
			}
		}
		
		System.out.print("<");
		for(int i = 0; i<N; i++) {
			System.out.print(result.pollFirst());
			if(i != N-1) {
				System.out.print(", ");
			}else {
				System.out.println(">");
			}
		}
	}
}

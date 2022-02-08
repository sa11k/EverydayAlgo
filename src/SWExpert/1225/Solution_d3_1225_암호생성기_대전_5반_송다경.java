import java.io.*;
import java.util.*;

public class Solution_d3_1225_암호생성기_대전_5반_송다경 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int test = 0; test<10; test++) {
			int tc = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 1;
			while(true) {
				int resultnum = queue.poll() - cnt;
				
				if(resultnum <= 0) {
					queue.offer(0);
					break;
				}
				queue.offer(resultnum);
				
				cnt++;
				if(cnt > 5) cnt = 1;
			}
			
			System.out.print("#"+tc+" ");
			while(!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}

}

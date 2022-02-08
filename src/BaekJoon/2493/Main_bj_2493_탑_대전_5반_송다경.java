import java.io.*;
import java.util.*;

public class Main_bj_2493_탑_대전_5반_송다경 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<int[]> stack = new Stack<>();

		for (int i = 1; i <= N; i++) {
			int top = Integer.parseInt(st.nextToken());
			while(stack.isEmpty()==false) {
				if(stack.peek()[1] >= top) {
					System.out.print(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(new int[] {i, top});
		}
	}
}

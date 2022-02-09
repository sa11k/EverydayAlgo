import java.io.*;
import java.util.*;

public class Solution_d3_3499_퍼펙트셔플_대전_5반_송다경 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Stack<String> stack1 = new Stack<>();
		Stack<String> stack2 = new Stack<>();
		Stack<String> result = new Stack<>();
		
		for(int i = 1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			stack1.clear();
			stack2.clear();
			result.clear();
			
			for(int j = 0; j<(N+1)/2; j++) {
				stack1.push(st.nextToken());
			}
			for(int j = 0; j<(N)/2; j++) {
				stack2.push(st.nextToken());
			}
			
			
			for(int j = 0; j<(N+1)/2; j++) {
				if(stack1.size() > stack2.size()) {
					result.push(stack1.pop());
					if(!stack1.isEmpty()) {
						result.push(stack2.pop());
					}
				}else if(stack1.size() == stack2.size()) {
					result.push(stack2.pop());
					if(!stack1.isEmpty()) {
						result.push(stack1.pop());
					}
				}
			}
			
			System.out.print("#"+i);
			for(int j = 0; j<N; j++) {
				System.out.print(" "+result.pop());
			}
			System.out.println();
		}
		
	}

}

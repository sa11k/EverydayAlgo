import java.io.*;
import java.util.*;

public class Solution_d4_1223_계산기2_대전_5반_송다경 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String infix = br.readLine();
			String postfix = "";
			
			Stack<Character> operator = new Stack<>();
			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < N; i++) {
				char c = infix.charAt(i);
				// 숫자면 num[]에 저장
				if(0 <= c - '0' && c - '0' <= 9) {
					postfix += c;
					continue;
				}
				
				if(operator.isEmpty()) {
					operator.push(c);
					continue;
				}
				
				if(c == '+') {
					while(!operator.isEmpty()) postfix += operator.pop();
					operator.push(c);
				}else if(c == '*') {
					while(!operator.isEmpty() && operator.peek() != '+') postfix += operator.pop();
					operator.push(c);
				}
			}
			
			while(!operator.isEmpty()) postfix += operator.pop();
			

			for(int i = 0; i<postfix.length(); i++) {
				char c = postfix.charAt(i);
				if(0<=c-'0' && c-'0' <= 9) {
					stack.push(c-'0');
					continue;
				}
				
				int x = stack.pop();
				int y = stack.pop();
				
				if(c == '+') stack.push(x+y);
				else if(c == '*') stack.push(x*y);
			}
			
			System.out.println("#"+tc+" " +stack.pop());
		}
	}

}

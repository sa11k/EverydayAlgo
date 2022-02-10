import java.util.*;
import java.io.*;

public class Solution_d4_1233_사칙연산유효성검사_대전_5반_송다경 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int result = -1;
			
			for(int i = 1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				char c = st.nextToken().charAt(0);
				
				if(c >= '0' && c<='9') {	// 해당 값이 숫자인데
					if(st.hasMoreTokens()) {// 토큰이 더 있으면
						result = 0;
					}
				}else {
					if(st.hasMoreTokens()) {
						if(st.hasMoreTokens()) {
							result = 1;
						}else {
							result = 0;
						}
					}else {
						result = 0;
					}
				}
			}
			System.out.println("#"+tc+" "+ result);
		}
	}

}

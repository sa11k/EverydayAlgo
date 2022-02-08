import java.io.*;
import java.util.*;

public class Solution_d3_2805_농작물수확하기_대전_5반_송다경 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수 받아오기
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			// 농장의 크기 받아오기
			int N = sc.nextInt();
			int sum = 0;
			
			// 윗부분 값 저장
			for(int i=N/2; i>=0; i--) {
                String s = sc.next();
                for(int j=i; j<N-i; j++) {
                	// 받아온 내용을 정수로 만들어주기 위해서 '0' 빼줌
                    sum += s.charAt(j)-'0';
                }
            }
			
			// 아래부분 값 저장
            for(int i=1; i<=N/2; i++) {
                String s = sc.next();
                for(int j=i; j<N-i; j++) {
                	// 받아온 내용을 정수로 만들어주기 위해서 '0' 빼줌
                    sum += s.charAt(j)-'0';
                }
            }
			
			System.out.printf("#%d %d", tc, sum);
			System.out.println();
		}
	
		
		
	}

}

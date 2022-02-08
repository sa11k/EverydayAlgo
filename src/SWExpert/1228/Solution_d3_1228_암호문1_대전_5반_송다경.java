import java.io.*;
import java.util.*;

public class Solution_d3_1228_암호문1_대전_5반_송다경 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			LinkedList<String> list = new LinkedList<String>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<N; i++) {
				list.add(st.nextToken());
			}
			
			int T = Integer.parseInt(br.readLine());
			StringTokenizer numSt = new StringTokenizer(br.readLine());
			for(int i = 0; i<T; i++) {
				String l = numSt.nextToken();
				int index = Integer.parseInt(numSt.nextToken());
				int num = Integer.parseInt(numSt.nextToken());
				for(int j = 0; j<num; j++) {
					list.add(index+j, numSt.nextToken());
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i = 0; i<10; i++) {
				System.out.print(list.poll()+" ");
			}
			System.out.println();
		}
	}

}

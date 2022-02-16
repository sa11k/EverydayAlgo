import java.util.*;
import java.io.*;

public class Main_jo_1828_냉장고_대전_5반_송다경 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] temp = new int[N][2];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			temp[i][0] = Integer.parseInt(st.nextToken());
			temp[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(temp, Comparator.comparingInt(o1 -> o1[1]));
		
		int ref = 1;
		int max = temp[0][1];
		
		for(int i = 1; i<N; i++) {
			if(max < temp[i][0]) {
				max = temp[i][1];
				ref++;
			}
		}
		
		System.out.println(ref);
		
		br.close();
	}

}

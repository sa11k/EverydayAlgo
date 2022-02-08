import java.util.*;

public class Solution_d3_1208_Flatten_대전_5반_송다경 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int N = sc.nextInt();
			int[] arr = new int[100];
			int res = 0;

			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			for (int j = 0; j < N; j++) {
				arr[0]+=1;
				arr[99]-=1;
				Arrays.sort(arr);
			}
			
			res = arr[99] - arr[0];
			
			System.out.println("#" + i + " " + res);

		}
		sc.close();
	}
}

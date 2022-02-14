import java.io.*;
import java.util.*;

/*
 * 1. 입력 : 9개 줄에 서로 다른 숫자가 입력됨 -> 9명의 난쟁이 모자에 적혀있는 숫자
 * 2. 출력 : 백설공주의 일곱 난쟁이가 쓰고 있는 모자에 적혀있는 숫자 (한 줄에 하나씩)
 * 3. 총9개의 숫자 중에서 7개를 순서없이 선택하는데 그 숫자들의 합이 100이 되어야 함 -> 조합
 * 4. 조합 -> 7개의 숫자를 뽑고 그 수를 다 더해서 100이 되면 그 7개의 숫자가 일곱 난쟁이가 쓰고 있는 모자에 적힌 숫자라고 판단하고 출력
 */

public class Main_bj_3040_백설공주와일곱난쟁이_대전_5반_송다경 {
    static int N = 9, R = 7;		// 돌아온 9명의 난쟁이 중에서 7명의 진짜 난쟁이 찾기
    static int[] input, result;		 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = new int[N];			// 돌아온 9명의 난쟁이 배열
        result = new int[R];		// 7명의 진짜 난쟁이 배열

        for(int i = 0; i<N; i++){
            input[i] = Integer.parseInt(br.readLine());	// 9명의 난쟁이 모자 숫자 입력받기
        }

        com(0, 0);		// 조합
        br.close();
    }

    static void com(int cnt, int start){	// cnt : 자리, start : 시작수
        if(cnt == R){						// 모든 자리를 다 채웠을 때,
            int sum = 0;
            for(int i = 0; i<R; i++){
                sum += result[i];			// 7명의 난쟁이 모자 숫자를 더해줌
            }
            if(sum == 100){					// 그 더한 값이 100이라면
                for(int i = 0; i<R; i++){
                    System.out.println(result[i]);	// 그 난쟁이들이 백설공주와 일곱난쟁이이기 때문에 한 줄에 하나씩 출력
                }
            }
            return;
        }
        
        // 조합에서는 순서없이 숫자를 선택해야하기 때문에 start를 지정해주어서 서로 다른 순서의 같은 숫자가 출력될 수 없도록 함.
        for(int i = start; i<N; i++){		
            result[cnt] = input[i];
            com(cnt+1, i+1);
        }
    }
}

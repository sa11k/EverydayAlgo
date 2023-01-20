import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] S;			// 수열
    static boolean[] isChecked;		// 부분 집합을 만들기 위한 배열
    static ArrayList<Integer> num;	// 나온 수들을 저장하는 리스트
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        isChecked = new boolean[N];
        num = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);			// 부분 집합 만들기

        Collections.sort(num);		// 부분 집합으로 만든 수들의 리스트 정렬

        setResultCheck();		// 만들 수 없는 가장 작은 수 찾기
    }
    
    // 부분 집합 만드는 함수
    static void subset(int cnt){
        if(cnt == N){
            int result = 0;
            // 이제까지 뽑힌 수들을 다 더하기
            for(int i = 0; i<N; i++){
                if(isChecked[i]) result += S[i];
            }
            // 다 더한 수를 리스트에 저장
            num.add(result);
            return;
        }

	// 부분 집합 구하기
        isChecked[cnt] = true;
        subset(cnt+1);
        isChecked[cnt] = false;
        subset(cnt+1);

    }

    // 만들 수 없는 가장 작은 수 찾기
    static void setResultCheck(){
    	// 가장 작은 수를 찾기 위한 방문 처리 배열
        boolean[] check = new boolean[num.get(num.size()-1)+1];
        // 리스트에 있는 수라면 방문 처리
        for(int i = 0; i<num.size(); i++){
            check[num.get(i)] = true;
        }
        // 방문 처리 되지 않은 수들 중 가장 작은 수를 출력
        for(int i = 0; i<check.length; i++){
            if(!check[i]){
                System.out.println(i);
                System.exit(0);
            }
        }
        // 배열 길이만큼 다 돌았다면 가장 작은 자연수가 배열 크기의 수이므로 해당 수 출력
        System.out.println(check.length);
        System.exit(0);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int N, K, left, right;
    static int[] A;
    static boolean[] robot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[2*N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<2*N; i++) A[i] = Integer.parseInt(st.nextToken());

        left = 0;
        right = N;

        int result = 0;

        while (K > 0) {
            result++;
            moveBelt();
            moveRobot();
            newRobot();
        }

        System.out.println(result);
    }

    static void moveBelt() {
        left--;
        right--;
        if(left == -1) left = 2*N - 1;
        if(right == -1) right = 2*N - 1;

        for(int i = N-2; i>=0; i--) {
            if(robot[i]) {
                robot[i] = false;
                if(i+1 < N-1) robot[i+1] = true;
            }
        }
    }

    static void moveRobot() {
        for(int i = N-2; i>=0; i--) {
            if(robot[i]) {
                int next = left + i + 1;
                if(next >= 2*N) next -= 2*N;
                if(!robot[i+1] && A[next] >= 1) {
                    robot[i] = false;
                    if(i+1 < N-1) robot[i+1] = true;
                    A[next]--;
                    if(A[next] == 0) K--;
                }
            }
        }
    }

    static void newRobot() {
        if(!robot[0] && A[left] > 0) {
            robot[0] = true;
            A[left]--;
            if(A[left] == 0) K--;
        }
    }
}
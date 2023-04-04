import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<R; i++) {
            int nextCal = Integer.parseInt(st.nextToken());
            switch (nextCal) {
                case 1 :
                    num1();
                    break;
                case 2 :
                    num2();
                    break;
                case 3 :
                    num3();
                    break;
                case 4 :
                    num4();
                    break;
                case 5 :
                    num5();
                    break;
                case 6 :
                    num6();
                    break;
            }
        }

        for(int i = 0; i<A.length; i++) {
            for(int j = 0; j<A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void num1() {
        int[][] next = new int[A.length][A[0].length];

        for(int i = A.length-1; i>=0; i--) {
            for(int j = 0; j<A[0].length; j++) {
                next[Math.abs(i-A.length+1)][j] = A[i][j];
            }
        }

        A = next.clone();
    }

    static void num2() {
        int[][] next = new int[A.length][A[0].length];

        for(int i = 0; i<A.length; i++) {
            for(int j = A[0].length-1; j>=0; j--) {
                next[i][Math.abs(j-A[0].length+1)] = A[i][j];
            }
        }

        A = next.clone();
    }

    static void num3() {
        int[][] next = new int[A[0].length][A.length];

        for(int j = 0; j<A[0].length; j++) {
            for(int i = A.length-1; i>=0; i--) {
                next[j][Math.abs(i-A.length+1)] = A[i][j];
            }
        }

        A = new int[A[0].length][A.length];

        A = next.clone();
    }

    static void num4() {
        int[][] next = new int[A[0].length][A.length];

        for(int j = A[0].length-1; j>=0; j--) {
            for(int i = 0; i<A.length; i++) {
                next[Math.abs(j-A[0].length+1)][i] = A[i][j];
            }
        }

        A = new int[A[0].length][A.length];

        A = next.clone();
    }

    static void num5() {
        int[][] next = new int[A.length][A[0].length];

        int[][] one = new int[A.length/2][A[0].length/2];
        int[][] two = new int[A.length/2][A[0].length/2];
        int[][] three = new int[A.length/2][A[0].length/2];
        int[][] four = new int[A.length/2][A[0].length/2];

        for(int i = 0; i<A.length; i++) {
            for(int j = 0; j<A[0].length; j++) {
                if(i<A.length/2 && j<A[0].length/2) one[i][j] = A[i][j];
                else if(i<A.length/2 && j>=A[0].length/2) two[i][j-A[0].length/2] = A[i][j];
                else if(i>=A.length/2 && j>=A[0].length/2) three[i-A.length/2][j-A[0].length/2] = A[i][j];
                else if(i>=A.length/2 && j<A[0].length/2) four[i-A.length/2][j] = A[i][j];
            }
        }

        for(int i = 0; i<A.length; i++) {
            for(int j = 0; j<A[0].length; j++) {
                if(i<A.length/2 && j<A[0].length/2) next[i][j] = four[i][j];
                else if(i<A.length/2 && j>=A[0].length/2) next[i][j] = one[i][j-A[0].length/2];
                else if(i>=A.length/2 && j>=A[0].length/2) next[i][j] = two[i-A.length/2][j-A[0].length/2];
                else if(i>=A.length/2 && j<A[0].length/2) next[i][j] = three[i-A.length/2][j];
            }
        }

        A = next.clone();
    }

    static void num6() {
        int[][] next = new int[A.length][A[0].length];

        int[][] one = new int[A.length/2][A[0].length/2];
        int[][] two = new int[A.length/2][A[0].length/2];
        int[][] three = new int[A.length/2][A[0].length/2];
        int[][] four = new int[A.length/2][A[0].length/2];

        for(int i = 0; i<A.length; i++) {
            for(int j = 0; j<A[0].length; j++) {
                if(i<A.length/2 && j<A[0].length/2) one[i][j] = A[i][j];
                else if(i<A.length/2 && j>=A[0].length/2) two[i][j-A[0].length/2] = A[i][j];
                else if(i>=A.length/2 && j>=A[0].length/2) three[i-A.length/2][j-A[0].length/2] = A[i][j];
                else if(i>=A.length/2 && j<A[0].length/2) four[i-A.length/2][j] = A[i][j];
            }
        }

        for(int i = 0; i<A.length; i++) {
            for(int j = 0; j<A[0].length; j++) {
                if(i<A.length/2 && j<A[0].length/2) next[i][j] = two[i][j];
                else if(i<A.length/2 && j>=A[0].length/2) next[i][j] = three[i][j-A[0].length/2];
                else if(i>=A.length/2 && j>=A[0].length/2) next[i][j] = four[i-A.length/2][j-A[0].length/2];
                else if(i>=A.length/2 && j<A[0].length/2) next[i][j] = one[i-A.length/2][j];
            }
        }

        A = next.clone();
    }
}
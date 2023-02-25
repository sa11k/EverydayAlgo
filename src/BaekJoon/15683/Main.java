import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxCCTV, result;
    static int[] cctvDirCnt;
    static int[][] room;
    static boolean[][] cctv;
    static List<CCTV> cctvList;

    static class CCTV {
        int i;
        int j;
        int cctvNum;

        public CCTV(int i, int j, int cctvNum) {
            this.i = i;
            this.j = j;
            this.cctvNum = cctvNum;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxCCTV = Integer.MIN_VALUE;
        result = N*M;

        room = new int[N][M];
        cctv = new boolean[N][M];
        cctvList = new ArrayList<>();

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] != 0) {
                    result--;
                    if(room[i][j] != 6) {
                        cctvList.add(new CCTV(i, j, room[i][j]));
                    }
                }
            }
        }

        cctvDirCnt = new int[cctvList.size()];
        cctvDirection(0);
        System.out.println(result-maxCCTV);

    }

    // 각 위치에서 상우하좌 cctv 범위 구하기
    // 상
    static int checkTop(int i, int j, boolean check) {
        int count = 0;
        for(int top = i-1; top>=0; top--) {
            if(room[top][j] == 6) return count;
            if(check) {
                if(room[top][j] > 0) continue;
                if(room[top][j] == 0) count++;
                room[top][j] -= 1;
            }
            else {
                count++;
                if(room[top][j] < 0) room[top][j] += 1;
            }
        }
        return count;
    }

    // 우
    static int checkRight(int i, int j, boolean check) {
        int count = 0;
        for(int right = j+1; right<M; right++) {
            if(room[i][right] == 6) return count;
            if(check) {
                if(room[i][right] > 0) continue;
                if(room[i][right] == 0) count++;
                room[i][right] -= 1;
            }
            else {
                count++;
                if(room[i][right] < 0) room[i][right] += 1;
            }
        }
        return count;
    }

    // 하
    static int checkDown(int i, int j, boolean check) {
        int count = 0;
        for(int down = i+1; down<N; down++) {
            if(room[down][j] == 6) return count;
            if(check) {
                if(room[down][j] > 0) continue;
                if(room[down][j] == 0)count++;
                room[down][j] -= 1;
            }
            else {
                count++;
                if(room[down][j] < 0) room[down][j] += 1;
            }
        }
        return count;
    }

    // 좌
    static int checkLeft(int i, int j, boolean check) {
        int count = 0;
        for(int left = j-1; left>=0; left--) {
            if(room[i][left] == 6) return count;
            if(check) {
                if(room[i][left] > 0) continue;
                if(room[i][left] == 0) count++;
                room[i][left] -= 1;
            }
            else {
                count++;
                if(room[i][left] < 0) room[i][left] += 1;
            }
        }
        return count;
    }

    static void showCCTV() {
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                System.out.print(room[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static void cctvDirection(int cnt) {
        if(cnt == cctvList.size()) {
            int sum = 0;
            for(int i = 0; i<cctvList.size(); i++) {
                sum += cctvDirCnt[i];
            }
            maxCCTV = Math.max(maxCCTV, sum);
            return;
        }

        switch (cctvList.get(cnt).cctvNum) {
            case 1:
                for(int i = 0; i<4; i++) {
                    if(i == 0) cctvDirCnt[cnt] = checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    else if(i == 1) cctvDirCnt[cnt] = checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    else if(i == 2) cctvDirCnt[cnt] = checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    else if(i == 3) cctvDirCnt[cnt] = checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, true);

                    cctvDirection(cnt+1);

                    if(i == 0) checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    else if(i == 1) checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    else if(i == 2) checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    else if(i == 3) checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                }
                break;

            case 2:
                for(int i = 0; i<2; i++) {
                    if(i == 0) {
                        cctvDirCnt[cnt] = checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    }
                    else if(i == 1) {
                        cctvDirCnt[cnt] = checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    }

                    cctvDirection(cnt+1);

                    if(i == 0) {
                        checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    }
                    else if(i == 1) {
                        checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    }
                }
                break;

            case 3:
                for(int i = 0; i<4; i++) {
                    if(i == 0) {
                        cctvDirCnt[cnt] = checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    }
                    else if(i == 1) {
                        cctvDirCnt[cnt] = checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    }
                    else if(i == 2) {
                        cctvDirCnt[cnt] = checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    }
                    else if(i == 3) {
                        cctvDirCnt[cnt] = checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    }

                    cctvDirection(cnt+1);

                    if(i == 0) {
                        checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    }
                    else if(i == 1) {
                        checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    }
                    else if(i == 2) {
                        checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    }
                    else if(i == 3) {
                        checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    }
                }
                break;

            case 4:
                for(int i = 0; i<4; i++) {
                    if(i == 0) {
                        cctvDirCnt[cnt] = checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    }
                    else if(i == 1) {
                        cctvDirCnt[cnt] = checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    }
                    else if(i == 2) {
                        cctvDirCnt[cnt] = checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    }
                    else if(i == 3) {
                        cctvDirCnt[cnt] = checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                        + checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, true);
                    }

                    cctvDirection(cnt+1);

                    if(i == 0) {
                        checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    }
                    else if(i == 1) {
                        checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    }
                    else if(i == 2) {
                        checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    }
                    else if(i == 3) {
                        checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                        checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                    }
                }
                break;

            case 5:
                cctvDirCnt[cnt] = checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                + checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                + checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, true)
                                + checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, true);

                cctvDirection(cnt+1);

                checkTop(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                checkRight(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                checkDown(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                checkLeft(cctvList.get(cnt).i, cctvList.get(cnt).j, false);
                break;
        }

    }
}
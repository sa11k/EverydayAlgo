import java.io.*;
import java.util.*;

class fireBall {
    int r;
    int c;
    int m;
    int s;
    int d;

    public fireBall(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

public class Main {
    static int N, M, K;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<fireBall>[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new List[N][N];

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c].add(new fireBall(r, c, m, s, d));
        }

        for(int i = 0; i<K; i++) move();

        System.out.println(sum());
    }

    static void move() {
//        System.out.println();
        List<fireBall>[][] tmp = new List[N][N];

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                tmp[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(map[i][j] != null) {
                    for(int k = 0; k<map[i][j].size(); k++) {
                        fireBall now = map[i][j].get(k);
                        int nr = now.r + (now.s % N) * dr[now.d];
                        int nc = now.c + (now.s % N) * dc[now.d];

                        if(nr > 0) nr %= N;
                        if(nc > 0) nc %= N;
                        if(nr < 0) nr = N - Math.abs(nr);
                        if(nc < 0) nc = N - Math.abs(nc);

                        tmp[nr][nc].add(new fireBall(nr, nc, now.m, now.s, now.d));
                    }
                    map[i][j] = new ArrayList<>();
                }
            }
        }

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(tmp[i][j] != null) {
                    int size = tmp[i][j].size();

                    if(size == 0) continue;
                    int nm = 0;
                    int ns = 0;
                    int nd = 0;
                    boolean isEven = true;
                    boolean isOdd = true;

                    for(int k = 0; k<size; k++) {
                        nm += tmp[i][j].get(k).m;
                        ns += tmp[i][j].get(k).s;
                        nd += tmp[i][j].get(k).d;
                        if(tmp[i][j].get(k).d % 2 == 0) isOdd = false;
                        else isEven = false;
                    }

                    if(size > 1) {
                        nm = nm/5;
                        ns = ns/size;

                        if(nm > 0) {
                            if(isEven || isOdd) {
                                map[i][j].add(new fireBall(i, j, nm, ns, 0));
                                map[i][j].add(new fireBall(i, j, nm, ns, 2));
                                map[i][j].add(new fireBall(i, j, nm, ns, 4));
                                map[i][j].add(new fireBall(i, j, nm, ns, 6));
                            }
                            else {
                                map[i][j].add(new fireBall(i, j, nm, ns, 1));
                                map[i][j].add(new fireBall(i, j, nm, ns, 3));
                                map[i][j].add(new fireBall(i, j, nm, ns, 5));
                                map[i][j].add(new fireBall(i, j, nm, ns, 7));
                            }
                        }
                    }

                    else {
                        map[i][j].add(new fireBall(i, j, nm, ns, nd));
                    }

//                    System.out.println(i + " " + j + " " + nm + " " + ns + " " + nd);
                }
            }
        }
    }

    static long sum() {
        long sum = 0;
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                if(map[i][j] != null) {
                    for(int k = 0; k<map[i][j].size(); k++) {
//                        System.out.println(i + " " + j + " " + map[i][j].get(k).m);
                        sum += map[i][j].get(k).m;
                    }
                }
            }
        }

        return sum;
    }
}
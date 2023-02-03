import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int before = 0, ans = 0;
        List<Point> points = new ArrayList<>();

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        Collections.sort(points);

        int x = points.get(0).x;
        int y = points.get(0).y;
        ans += y - x;

        for(int i = 1; i<points.size(); i++){
            int nx = points.get(i).x;
            int ny = points.get(i).y;

            if((x <= nx) && (ny <= y)) continue;
            else if(nx < y) ans += ny - y;
            else ans += ny - nx;

            x = nx;
            y = ny;
        }

        System.out.println(ans);
    }
}


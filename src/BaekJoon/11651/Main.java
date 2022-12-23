import java.io.*;
import java.util.*;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.y != o2.y){
                    return o1.y - o2.y;
                }else {
                    return o1.x - o2.x;
                }
            }
        };

        Collections.sort(points, comparator);

        for(int i = 0; i<N; i++){
            System.out.println(points.get(i).x + " " + points.get(i).y);
        }
    }
}
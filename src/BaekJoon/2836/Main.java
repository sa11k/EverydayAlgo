import java.io.*;
import java.util.*;

class Taxi implements Comparable<Taxi>{
    long start;
    long end;

    public Taxi(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Taxi o) {
        if(this.end == o.end) return (int)(this.start - o.start);
        else return (int)(this.end - o.end);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long result = M;
        List<Taxi> destinations = new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start > end) {
                destinations.add(new Taxi(start, end));
            }
        }

        Collections.sort(destinations);

        long small = destinations.get(0).end;
        long big = destinations.get(0).start;

        for(int i = 1; i<destinations.size(); i++){
            long start = destinations.get(i).end;
            long end = destinations.get(i).start;

            if(start <= big) big = Math.max(big, end);
            else {
                result += 2 * (big - small);
                small = start;
                big = end;
            }
        }

        result += 2 * (big - small);

        System.out.println(result);

    }
}


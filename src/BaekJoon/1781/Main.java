import java.io.*;
import java.util.*;

class Homework implements Comparable<Homework> {
    int no;
    int deadline;
    int noodle;

    public Homework(int no, int deadline, int noodle) {
        this.no = no;
        this.deadline = deadline;
        this.noodle = noodle;
    }

    @Override
    public int compareTo(Homework o) {
        if(this.deadline == o.deadline) return o.noodle - this.noodle;
        return this.deadline - o.deadline;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int nowDay = 1;
        int result = 0;
        List<Homework> homeworkList = new ArrayList<>();
        PriorityQueue<Integer> noodles = new PriorityQueue<>();

        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int noodle = Integer.parseInt(st.nextToken());
            homeworkList.add(new Homework(i+1, deadline, noodle));
        }

        Collections.sort(homeworkList);

        for(int i = 0; i<N; i++) {
            Homework hw = homeworkList.get(i);
            if(noodles.size() < hw.deadline) noodles.add(hw.noodle);
            else if(noodles.size() == hw.deadline) {
                if(noodles.peek() < hw.noodle) {
                    noodles.poll();
                    noodles.add(hw.noodle);
                }
            }
        }

        while(!noodles.isEmpty()) {
            result += noodles.poll();
        }

        System.out.println(result);

    }
}


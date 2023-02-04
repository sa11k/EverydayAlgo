import java.io.*;
import java.util.*;

class Time implements Comparable<Time>{
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if(this.start == o.start) return this.end - o.end;
        else return this.start - o.start;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Time> meetings = new ArrayList<>();
        List<Integer> nowMeetings = new ArrayList<>();

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(meetings);

        int result = 1;
        nowMeetings.add(meetings.get(0).end);

        for(int i = 1; i<N; i++){
            int start = meetings.get(i).start;
            int end = meetings.get(i).end;
            boolean haveMeetingRoom = false;
            for(int j = 0; j<nowMeetings.size(); j++){
                if(start >= nowMeetings.get(j)){
                    haveMeetingRoom = true;
                    nowMeetings.remove(j);
                    nowMeetings.add(end);
                    break;
                }
            }
            if(!haveMeetingRoom) {
                result++;
                nowMeetings.add(end);
            }
        }

        System.out.println(result);
    }
}


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        char [] alpabet = new char[N];

        for(int i=0;i<N;i++) {
            alpabet[i] = br.readLine().charAt(0);
        }

        int start=0, end=N-1;
        while(start<=end) {
            if((int)alpabet[start]<(int)alpabet[end]) {
                result.add(alpabet[start++]);
            } else if((int)alpabet[start]==(int)alpabet[end]) {
                int front = start, back=end;
                boolean check = true;

                while(alpabet[front]==alpabet[back]) {
                    if(back>0) back--;
                    if(front<N-1) front++;

                    if((int)alpabet[front]<(int)alpabet[back]) check=true;
                    else if((int)alpabet[front]>(int)alpabet[back]) check=false;
                }

                if(check) result.add(alpabet[start++]);
                else result.add(alpabet[end--]);

            } else {
                result.add(alpabet[end--]);
            }
        }

        for(int i=0;i<result.size();i++) {
            if(i!=0 && i%80==0) sb.append("\n");
            sb.append(result.get(i));
        }
        System.out.println(sb.toString());

    }
}
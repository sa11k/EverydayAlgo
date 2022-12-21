import java.io.*;
import java.util.*;

class Calculate{
    String cal;
    long num;

    public Calculate(String cal, long num) {
        this.cal = cal;
        this.num = num;
    }
}

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        Queue<Calculate> queue = new LinkedList<>();
        boolean[] check = new boolean[1000000001];

        check[s] = true;
        queue.add(new Calculate("", s));

        if(s == t){
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()){
            Calculate now = queue.poll();
            long nowNum = now.num;
            String nowCal = now.cal;
            long mulNum = nowNum * nowNum;
            long plusNum = nowNum + nowNum;
            long minusNum = nowNum - nowNum;

            if(check(mulNum) && !check[(int) mulNum]){
                queue.add(new Calculate(nowCal+"*", mulNum));
                check[(int) mulNum] = true;
                if(mulNum == t){
                    sb.append(nowCal).append("*");
                    System.out.println(sb);
                    System.exit(0);
                }
            }

            if(check(plusNum) && !check[(int) plusNum]){
                queue.add(new Calculate(nowCal+"+", plusNum));
                check[(int) plusNum] = true;
                if(plusNum == t){
                    sb.append(nowCal).append("+");
                    System.out.println(sb);
                    System.exit(0);
                }
            }

            if(check(minusNum) && !check[(int) minusNum]){
                queue.add(new Calculate(nowCal+"-", minusNum));
                check[(int) minusNum] = true;
                if(minusNum == t){
                    sb.append(nowCal).append("-");
                    System.out.println(sb);
                    System.exit(0);
                }
            }

            if(nowNum != 0){
                long divNum = nowNum / nowNum;

                if(check(divNum) && !check[(int) divNum]){
                    queue.add(new Calculate(nowCal+"/", divNum));
                    check[(int) divNum] = true;
                    if(divNum == t){
                        sb.append(nowCal).append("/");
                        System.out.println(sb);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(-1);

    }

    static boolean check(long n){
        return n>=1 && n<= 1000000000;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String expression = br.readLine();

        Stack<Character> exp = new Stack<>();

        for(int i = 0; i<expression.length(); i++) {
            char now = expression.charAt(i);
            switch (now) {
                case '(' :
                    exp.push(now);
                    break;
                case ')' :
                    while (!exp.isEmpty() && exp.peek() != '(')
                        sb.append(exp.pop() + "");
                    if(!exp.isEmpty()) exp.pop();
                    break;
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    while(!exp.isEmpty() && priority(exp.peek()) >= priority(now))
                        sb.append(exp.pop() + "");
                    exp.push(now);
                    break;
                default :
                    sb.append(now + "");
            }
        }
        while (!exp.isEmpty()) sb.append(exp.pop() + "");
        System.out.println(sb);
    }

    static int priority(char op) {
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0;
    }
}
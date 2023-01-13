import java.io.*;
import java.util.*;

class Room{
    String roomType;
    int amount;
    ArrayList<Integer> canGo;
    boolean visit;

    public Room(String roomType, int amount, ArrayList<Integer> canGo) {
        this.roomType = roomType;
        this.amount = amount;
        this.canGo = canGo;
    }
}

public class Main {
    static boolean result;
    static int n;
    static Room[] rooms;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            result = false;
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            rooms = new Room[n];
            for(int i = 0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String roomType = st.nextToken();
                int amount = Integer.parseInt(st.nextToken());
                ArrayList<Integer> canGo = new ArrayList<>();
                while (st.hasMoreTokens()){
                    canGo.add(Integer.parseInt(st.nextToken()));
                }
                canGo.remove(canGo.size()-1);
                rooms[i] = new Room(roomType, amount, canGo);
            }
            move(0, 0);
            if(!result){
                System.out.println("No");
            }
        }
    }

    static void move(int start, int money){
        if(rooms[start].roomType.equals("T")) money -= rooms[start].amount;
        else{
            if(money < rooms[start].amount){
                money = rooms[start].amount;
            }
        }

        if(money >= 0){
            if(start + 1 == n){
                System.out.println("Yes");
                result = true;
            }

            rooms[start].visit = true;

            for(int i = 0; i<rooms[start].canGo.size(); i++){
                if(!rooms[rooms[start].canGo.get(i)-1].visit){
                    move(rooms[start].canGo.get(i)-1, money);
                }
            }

            rooms[start].visit = false;

        }

        else {
            if(rooms[start].roomType.equals("T")) money += rooms[start].amount;
            return;
        }
    }
}
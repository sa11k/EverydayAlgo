import java.util.Scanner;

public class Main {
    public static int toggle(int n){
        if(n == 0){
            n = 1;
        }else if(n == 1){
            n = 0;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] switchState = new int[N];

        // 현재 스위치 상태 받아오기
        for(int i = 0; i<N; i++){
            switchState[i] = Integer.parseInt(sc.next());
        }

        // 학생 수만큼 반복
        int stuNum = sc.nextInt();
        for(int i = 0; i<stuNum; i++){
            int stu = Integer.parseInt(sc.next());
            int nowSwitch = Integer.parseInt(sc.next());

            switch (stu){
                case 1:
                    for(int j = 1; nowSwitch * j<=switchState.length; j++) {
                        switchState[(nowSwitch * j)-1] = toggle(switchState[(nowSwitch * j)-1]);
                    }
                    break;
                case 2:
                    switchState[nowSwitch-1] = toggle(switchState[nowSwitch-1]);
                    for(int j = 1; j<=Math.min(nowSwitch-1, switchState.length-nowSwitch); j++){
                        if(switchState[(nowSwitch-j)-1]==switchState[(nowSwitch+j)-1]){
                            switchState[(nowSwitch-j)-1] = toggle(switchState[(nowSwitch-j)-1]);
                            switchState[(nowSwitch+j)-1] = toggle(switchState[(nowSwitch+j)-1]);
                        }else{
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        for(int i=0; i<switchState.length; i++) {
            System.out.print(switchState[i] + " ");
            if(i % 20 == 19)
                System.out.println();
        }
    }
}

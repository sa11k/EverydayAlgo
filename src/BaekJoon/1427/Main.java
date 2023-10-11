import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int[] nums = new int[num.length()];

        for(int i = 0; i<nums.length; i++) {
            nums[i] = num.charAt(i) - '0';
        }

        Arrays.sort(nums);

        for(int i = nums.length-1; i>=0; i--) {
            System.out.print(nums[i]);
        }
    }
}
package com.ssafy.io;

import java.io.*;
import java.util.*;

public class Solution_d3_1289_원재의메모리복구_대전_5반_송다경 {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_d3_1289.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int count = 0;
		sc.nextLine();
		for(int tc = 1; tc <= T; tc++) {
			String line = sc.nextLine();
			if(line.charAt(0)=='1') {
				count = 1;
			}
			for(int i = 0; i < line.length()-1; i++) {
				if(line.charAt(i)!=line.charAt(i+1)) {
					count++;
				}
			}
			System.out.println("#"+tc+" "+count);
			count = 0;
		}
		
		
		
		sc.close();
	}

}

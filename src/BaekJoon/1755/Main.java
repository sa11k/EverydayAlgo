import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static String numToString[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	//숫자를 문자로 변환할 때 사용할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt(); //숫자 입력
		int size = N-M+1; //숫자의 크기만큼 배열 만들어주기
		Node node[] = new Node[size]; //숫자와 숫자를 문자열로 변환한 정보 저장할 Node배열

		
		int idx = M; //시작 순서는 M부터
		for(int i=0;i<size;i++) {
			node[i] = new Node(idx); //Node 클래스에 숫자 넣어주면서 문자열로 변환하기
			idx++;
		}

		Arrays.sort(node);
		for(int i=0;i<size;i++) {
			if(i!=0 && i%10 == 0) System.out.println();
			System.out.print(node[i].number+" "); //출력 10개씩!
		}
	}
	
	static class Node implements Comparable<Node>{ //문자열 순서대로 정렬하기 위해 implements
		int number;
		String numberToString;
		
		public Node(int number) {
			super();
			this.number = number;
			int num10 = number/10 ; //10의 자리수
			int num1 = number % 10; //1의 자리수
			
			if(number >=10) {//10의 자리수일 경우 문자열 변환
				numberToString = numToString[num10]+" "+numToString[num1];
			}
			else {//1의 자리수일 경우 zero안붙게  num1으로만 문자열 변환
				numberToString = numToString[num1];
			}
		}
		
		@Override
		public int compareTo(Node o) {//문자열 순서대로 정렬하기 위한 compareTo
			return this.numberToString.compareTo(o.numberToString);
		}
	
	}
}
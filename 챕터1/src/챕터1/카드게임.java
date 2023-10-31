package 챕터1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//가장 맨 위에 있는 카드를 버리고 그 다음 카드를 만 아래에 넣는다. 이걸 반복
public class 카드게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList();
		int N = sc.nextInt();
		for(int i =1; i<=N; i++) {
			myQueue.add(i);
		}
		while (myQueue.size()>1) {
			myQueue.poll();
			myQueue.add(myQueue.poll());
			
		}
		System.out.println(myQueue.poll());
	}

}

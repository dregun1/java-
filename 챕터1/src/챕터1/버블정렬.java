package 챕터1;

import java.util.Scanner;
//ex)5    5 4 3 2 1  >>> 1 2 3 4 5
public class 버블정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //5
		int[] A = new int[N]; //5크기의 배열 A
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt(); 
		}
		for (int i = 0; i<N-1; i++) { //i= 0 1 2 3
			for(int j= 0; j<N-1-i; j++) { //j = 0 1 2 3, j = 0 1 2 , j = 0 1,...
						
				if (A[j] > A[j+1]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}
		for (int i =0; i<N; i++) {
			System.out.println(A[i]);
		}
	}
}

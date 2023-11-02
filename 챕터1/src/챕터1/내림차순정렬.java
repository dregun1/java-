package 챕터1;

import java.util.Scanner;
//선택정렬  입력 2143 출력 4321
public class 내림차순정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] A = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {
			A[i] = Integer.parseInt(str.substring(i, i+1));  //i번째부터 i+1전까지니까 i한자리만 잘라냄.
		}
		for (int i = 0; i < str.length(); i++) {
			int Max = i;
			for(int j = i + 1; j < str.length(); j++) {
				if (A[j] > A[Max])
					Max = j;
			}
			if (A[i] < A[Max]) {
				int temp = A[i];
				A[i] = A[Max];
				A[Max] = temp;
			}
		}
		for (int i = 0; i < str.length(); i++)
			System.out.println(A[i]);
		
	}
}

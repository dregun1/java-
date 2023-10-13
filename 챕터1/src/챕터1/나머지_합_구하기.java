package 챕터1;

import java.util.Scanner;

public class 나머지_합_구하기 {
//배열에서 m 으로 나누어지는 연속된 수 구하는 문제.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] S = new long[N];
		long[] C = new long[M];
		long answer = 0;
		S[0] = sc.nextInt();
		for (int i = 1; i < N; i++) {
			S[i] = S[i-1] + sc.nextInt();
		}
		for (int i= 0; i<N; i++) {
			int remainder = (int)(S[i] % M);
			
			if(remainder == 0)answer++;
			
			C[remainder]++;   
		}
		for (int i = 0; i<M; i++) {
			if (C[i] > 1) {
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		System.out.println(answer);
	}

}

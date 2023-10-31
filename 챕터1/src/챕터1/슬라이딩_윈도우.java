package 챕터1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//뭔가 길고 중요해보이니까 나중에 한번 풀어보자.
public class 슬라이딩_윈도우 {
	
	static int checkArr[];
	static int myArr[];
	static int checkSecret; //몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken()); //문자열 크기 S
		int P = Integer.parseInt(st.nextToken()); //부분 문자열의 크기 P
		
		int Result = 0;
		char A[] = new char[S];
		checkArr = new int[4];
		myArr = new int[4];
		checkSecret = 0;
		A = bf.readLine().toCharArray(); //DNA문자열 데이터
		st = new StringTokenizer(bf.readLine()); //부분 문자열에 포함돼야 할 A,C,G,T의 최소 개수
		for (int i = 0; i < 4; i++) { 
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0)
				checkSecret++; //4개 중에 한 개는 이미 만족한 셈.
		}
		for(int i = 0; i < P; i++) { //초기 P부분 문자열 처리 부분
			Add(A[i]);
		}
		if (checkSecret == 4) //만약 4개를 다 만족한다면
			Result++;
		
		///****슬라이딩 윈도우 처리 부분****
		for (int i = P; i < S; i++) { //한칸씩 옮기니까 i++가 맞네. P부터 세는 것은 한칸 옮긴상태에서 시작한다는 것. 
			int j = i - P; // j는 뭐지? 옮기고 나서 앞에 남은 칸이네. A[j=0]을 빼는 것부터 시작.
			Add(A[i]); //마지막 꺼만(!중요) 이미 앞에 건 다 ADD로 세놨으니까.
			Remove(A[j]);
			if (checkSecret == 4) //4자릿수와 관련된 크기가 모두 충족될 때 유효한 비밀번호
				Result++;
		}
		System.out.println(Result);
		bf.close();
	}
	
	private static void Add(char c) { //새로 들어온 문자를 처리하는 함수
		switch (c) {
		case 'A' : //A가 들어왔어
			myArr[0]++; //A가 들어온 갯수를 늘리는 거구나
			if (myArr[0] == checkArr[0]) //A의 갯수가 조건의 갯수와 만족하면
				checkSecret++; //A해결
			break;
		case 'C' :
			myArr[1]++;
			if (myArr[1] == checkArr[1])
				checkSecret++;
			break;
		case 'G' :
			myArr[2]++;
			if (myArr[2] == checkArr[2])
				checkSecret++;
			break;
		case 'T' :
			myArr[3]++;
			if (myArr[3] == checkArr[3])
				checkSecret++;
			break;
			
		}
	}
	
	private static void Remove(char c) { //제거되는 문자를 처리하는 함수
		switch(c) {
		case 'A' :
			if(myArr[0] == checkArr[0])
				checkSecret--;
			myArr[0]--;
			break;
		case 'C' :
			if(myArr[1] == checkArr[1])
				checkSecret--;
			myArr[1]--;
			break;
		case 'G' :
			if(myArr[2] == checkArr[2])
				checkSecret--;
			myArr[2]--;
			break;
		case 'T' :
			if(myArr[3] == checkArr[3])
				checkSecret--;
			myArr[3]--;
			break;
		}
	}
}

package 챕터1;
//버블소트를 할 때 한번도 돌지 않는 i for문은 몇번째인가.
//입력 5 10 1 5 2 3   출력 3
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 버블소트1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		mData[] A = new mData[N];
		for (int i = 0; i < N; i++) {
			A[i] = new mData(Integer.parseInt(reader.readLine()),i);
		}
		Arrays.sort(A);
		int Max = 0;
		for (int i=0; i<N; i++) {
			if(Max < A[i].index - i)
				Max = A[i].index - i;
		}
		System.out.println(Max + 1);
	}
}

class mData implements Comparable<mData>{
	int value;
	int index;
	
	public mData(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	@Override
	public int compareTo(mData o) {
		return this.value - o.value;
	}
}

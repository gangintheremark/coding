import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	static int S, P;
	static int[] myCount = new int[4];
	static int AC, CC, GC, TC;
	static int A, C, G, T;

	/*
	 * 0: A 1: C 2: G 3: T
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int result = 0;

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		String str = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		// 윈도우 초기값 설정
		for (int i = 0; i < P; i++) {
			if(str.charAt(i) == 'A') AC++;
			else if(str.charAt(i) == 'C') CC++;
			else if(str.charAt(i) == 'G') GC++;
			else if(str.charAt(i) == 'T') TC++;
		}

		if (check())
			result++;

		int left = 0;
		int right = P;

		while (right < S) {
			if(str.charAt(left) == 'A') AC--;
			else if(str.charAt(left) == 'C') CC--;
			else if(str.charAt(left) == 'G') GC--;
			else if(str.charAt(left) == 'T') TC--;
			
			if(str.charAt(right) == 'A') AC++;
			else if(str.charAt(right) == 'C') CC++;
			else if(str.charAt(right) == 'G') GC++;
			else if(str.charAt(right) == 'T') TC++;
			

			if (check())
				result++;

			left++;
			right++;
		}
		System.out.println(result);
	}

	public static boolean check() {
		if(AC < A || CC < C || GC < G || TC < T ) return false;
		return true; 
	}
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int result, n;
	static int[] arr, numbers;
	static boolean[] selected;
	
	public static void subset(int cnt, int leftW, int rightW) {
		if(rightW > leftW) return;
		if(cnt == n) {
			result++;
			return;
		}
		
		subset(cnt+1, leftW + numbers[cnt], rightW );
		subset(cnt+1, leftW, rightW + numbers[cnt]);
	}
	
	public static void perm(int cnt) {
		
		if(cnt == n) {
			// 부분집합 구한 후 조건에 맞는지 확인
			// 맨 첫 추는 무조건 왼쪽이여야 함
			subset(1, numbers[0], 0);
			return;
		}
		for (int i = 0; i < n; i++) {
			if(!selected[i]) {
				selected[i] = true;
				numbers[cnt] = arr[i];
				perm(cnt+1);
				selected[i] = false;
			}
		}
			
	}
	
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			numbers = new int[n];
			selected = new boolean[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			
			perm(0);
			
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
			result = 0;
		}
		System.out.println(sb);
	}
}
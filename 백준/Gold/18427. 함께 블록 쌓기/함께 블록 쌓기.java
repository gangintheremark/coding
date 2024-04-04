import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		List<Integer>[] list = new List[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new ArrayList<Integer>();
			while (st.hasMoreTokens())
				list[i].add(Integer.parseInt(st.nextToken()));
		}

		int[][] dp = new int[n + 1][h + 1]; // dp[i][j]: i번 학생이 j 높이를 만들 수 있는 경우의 수 저장

		// 모든 학생이 높이 0 을 만들 수 있으므로 dp[][0] 을 1로 초기화
		for (int i = 1; i <= n; i++)  dp[n][0] = 1;
		
		for (int i = 1; i <= n; i++) {
			// i 번 학생이 j 높이를 만들 수 있는지 
			for (int j = 1; j <= h; j++) {
				// 한 명의 학생이 하나의 블록만 사용 가능하므로 가지고 있는 블록이 만드려는 높이보다 작거나 같으면
				// (j 높이의 내가 가진 블록 수) + (이전 학생이 j 높이까지 만든 블록 수) + (이전 학생이 j - 내가 가진 블록의 높이까지 만든 블록 수)
				for(int block : list[i]) {
					if( j == block ) dp[i][j]++;
					if(j > block) {
						dp[i][j] += dp[i-1][j-block];
				
					}
		
				}
				dp[i][j] += dp[i-1][j];
				dp[i][j] %= 10007;
			}
		}
		
		System.out.println(dp[n][h]);
	}
}
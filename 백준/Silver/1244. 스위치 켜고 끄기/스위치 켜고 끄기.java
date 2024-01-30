import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[] S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 스위치 개수
		S = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}

		int num = Integer.parseInt(br.readLine());
		int gender, snum;

		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			snum = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				int tmp = snum;
				int count = 2;
				while (tmp <= N) {
					S[tmp] = S[tmp] == 0 ? 1 : 0;
		
					tmp = snum * count++;
				}
			} else {
				S[snum] = S[snum] == 0 ? 1 : 0;
		
				boolean flag = true;
				int tmp = 1;
				while (flag) {
					if (snum+tmp <= N && snum-tmp > 0 && S[snum + tmp] == S[snum - tmp]) {
						S[snum + tmp] = S[snum - tmp] = S[snum + tmp] == 0 ? 1 : 0;
						tmp++;
					} else {
						flag = false;
					}
				}
			}
		}

	
		for(int i=1; i<=N;i++) {
			System.out.print(S[i] + " ");

			if(i % 20 == 0) {
				System.out.println();
			}
			
		}
	}
}
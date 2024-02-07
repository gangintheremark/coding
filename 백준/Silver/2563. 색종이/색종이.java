import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[100][100];
		for (int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
				
						board[i][j] = 1;
				}
			}
		}

		int sum = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (board[i][j] == 1)
					sum++;
			}
		}

		System.out.println(sum);

	}

}

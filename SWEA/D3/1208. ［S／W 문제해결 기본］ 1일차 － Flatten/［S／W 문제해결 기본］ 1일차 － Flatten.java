import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int H[] = new int[100];

		for (int t = 1; t <= 10; t++) {
			int maxCount = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++)
				H[i] = Integer.parseInt(st.nextToken());

			int count = 0;
			while (count != maxCount) {
				Arrays.sort(H);
				
				H[99] -= 1;
				H[0] += 1;
				count++;
			}

			Arrays.sort(H);
			System.out.printf("#%d %d\n",t,H[99] - H[0]);
		}
	}
}

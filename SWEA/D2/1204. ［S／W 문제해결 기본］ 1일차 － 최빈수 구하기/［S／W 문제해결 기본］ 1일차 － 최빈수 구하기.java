import java.util.*;

public class Solution {
	static int[] count;

	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);

		int T = s.nextInt();

		for (int t = 0; t < T; t++) {

			int n = s.nextInt();
			count = new int[101];

			int maxCount = 0;
			int num = 0;

			for (int i = 0; i < 1000; i++) {
				int tmp = s.nextInt();

				count[tmp]++;
				if (maxCount < count[tmp]) {
					num = tmp;
					maxCount = count[tmp];
				} else if(maxCount == count[tmp]) {
					num = Math.max(num, tmp);
				}
			}

			System.out.println("#" + n + " " + num);
		}
	}
}
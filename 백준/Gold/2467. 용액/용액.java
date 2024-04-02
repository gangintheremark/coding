import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int lt = 0;
		int rt = n - 1;

		int minMix = Integer.MAX_VALUE;
		int a = 0, b = 0;
		while (lt < rt && rt < n) {
			int mix = arr[lt] + arr[rt];

			if (Math.abs(mix) <= minMix) {

				minMix = Math.abs(mix);
				a = arr[lt];
				b = arr[rt];

			} 
			if (mix > 0) {
				rt--;
			} else
				lt++;

		}

		System.out.println(a + " " + b);
	}
}
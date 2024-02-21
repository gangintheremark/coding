import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		double[] score = new double[N];
		for (int i = 0; i < N; i++) {
			score[i] = (arr[i] * 100) / max + (arr[i] % 100 * 0.01);

		}

		System.out.println(Arrays.stream(score).average().getAsDouble());
	}

}

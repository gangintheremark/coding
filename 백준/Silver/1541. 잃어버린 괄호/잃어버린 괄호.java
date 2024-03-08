import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = br.readLine();

		String[] arr = str.split("-");

		int sum = 0, minus = 0;
		String[] tmp = arr[0].split("\\+");

		for (String s : tmp)
			sum += Integer.parseInt(s);

		for (int i = 1; i < arr.length; i++) {
			String[] temp = arr[i].split("\\+");
			for (String s : temp)
				minus += Integer.parseInt(s);
		}

		System.out.println(sum - minus);
	}
}

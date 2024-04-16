import java.util.*;
import java.io.*;

public class Main {

    static int n, result, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if( i != j) tmp.add(arr[j]);
            }

            int left = 0;
            int right = tmp.size() - 1;
            while(left < right) {
                int sum = tmp.get(left) + tmp.get(right);
                if(sum == arr[i]) {
                    result++;
                    break;
                }

                if( sum < arr[i] )
                    left++;
                else
                    right--;
            }
            tmp.clear();
        }

        System.out.println(result);
    }
}

import java.util.*;

class Main {

    public static void main(String[] args) {
        Main T = new Main();
        Scanner s = new Scanner(System.in);
        TreeSet<Integer> ts = new TreeSet<>();

        int n = s.nextInt();
        int[][] arr = new int[n][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        int answer = 0;
        int count;

        for (int i = 0; i < n; i++) {
            ts.clear();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != k && arr[i][j] == arr[k][j]) {
                        ts.add(k);
                    }
                }
            }
            if (ts.size() > max) {
                max = ts.size();
                answer = i+1 ;
            }
        }
        System.out.println(answer);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Balloon {
    int index;
    int num;

    public Balloon(int index, int num) {
        this.index = index;
        this.num = num;
    }


}


public class Main {
    static Balloon[] list;
    static int N;

    public static int minus(int index, int move) {
        int cnt = 0;

        while (cnt != Math.abs(move)) {
            index--;
            if (index == -1) {
                index = N - 1;
            }
            if (list[index].num != 0)
                cnt++;
        }
        return index;
    }

    public static int plus(int index, int move) {
        int cnt = 0;
        while (cnt != move) {
            index++;
            if (index == N) {
                index = 0;
            }
            if (list[index].num != 0)
                cnt++;
        }
        return index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        list = new Balloon[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = new Balloon(i, Integer.parseInt(st.nextToken()));
        }

        Balloon b = list[0];
        sb.append(b.index + 1).append(' ');
        int count = 0;
        int idx = -1;
        for (int i = 1; i < N; i++) {
            int move = b.num;
            b.num = 0;
            if (move < 0) {
                idx = minus(b.index, move);
            } else {
                idx = plus(b.index, move);
            }

            b = list[idx];
            sb.append(b.index + 1).append(' ');

        }

        System.out.println(sb);

    }
}
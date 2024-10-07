import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static LinkedList<Integer>[] lists;

    public static void main(String[] args) throws Exception {
        lists = new LinkedList[5];

        for (int i = 0; i < 5; i++) {
            lists[i] = new LinkedList();
        }

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                lists[i + 1].add(str.charAt(j) - '0');
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken()); // 1이면 시계 -1 반시계

            int left = lists[idx].get(6);
            int right = lists[idx].get(2);

            if (dir == 1) {
                int tmp = lists[idx].removeLast();
                lists[idx].addFirst(tmp);
            } else {
                int tmp = lists[idx].removeFirst();
                lists[idx].addLast(tmp);
            }

            // 나머지 톱니바퀴
            rotateLeft(idx, left, dir);
            rotateRight(idx, right, dir);
        }

        int result = (lists[1].get(0) == 0 ? 0 : 1) + (lists[2].get(0) == 0 ? 0 : 2) + (lists[3].get(0) == 0 ? 0 : 4) + (lists[4].get(0) == 0 ? 0 : 8);
        System.out.println(result);
    }

    public static void rotateLeft(int cur, int left, int dir) {
        if (cur == 1) return;

        cur--;

        int nleft = lists[cur].get(6);
        int nright = lists[cur].get(2);

        if (nright != left) {
            // 반대방향으로 회전
            if (dir != 1) {
                int tmp = lists[cur].removeLast();
                lists[cur].addFirst(tmp);
            } else {
                int tmp = lists[cur].removeFirst();
                lists[cur].addLast(tmp);
            }

            rotateLeft(cur, nleft, dir == 1 ? -1 : 1);
            return;
        } else return;
    }

    public static void rotateRight(int cur, int right, int dir) {
        if (cur == 4) return;

        cur++;
        int nleft = lists[cur].get(6);
        int nright = lists[cur].get(2);

        if (nleft != right) {
            // 반대방향으로 회전
            if (dir != 1) {
                int tmp = lists[cur].removeLast();
                lists[cur].addFirst(tmp);
            } else {
                int tmp = lists[cur].removeFirst();
                lists[cur].addLast(tmp);
            }

            rotateRight(cur, nright, dir == 1 ? -1 : 1);
            return;
        } else return;
    }
}
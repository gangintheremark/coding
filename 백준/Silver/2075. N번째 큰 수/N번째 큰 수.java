import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                q.offer(s.nextInt());
            }
        }

        int count = 1;
        while(count != n) {
            q.poll();
            count++;
        }
        System.out.println(q.peek());

    }
}
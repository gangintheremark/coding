import java.util.*;
import java.io.*;

public class Solution {

    static int NODE_MAX = 5000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;
        Node[] nodeArr;
        int nodeCnt;

        public LinkedList() {
            head = null;
            nodeArr = new Node[NODE_MAX];
            nodeCnt = 0;
        }

        // data 를 값으로 갖는 새로운 node 생성
        Node getNewNode(int data) {
            nodeArr[nodeCnt] = new Node(data);
            return nodeArr[nodeCnt++];
        }

        // idx개 이후 nums 배열 추가
        void insert(int idx, int[] nums) {
            int num = 0;
            if(idx == 0) {
                // 맨 앞에 추가하는 경우 head가 변경되어야 함 -> 맨 앞 데이터만 먼저 추가
                Node newNode = getNewNode(nums[0]);
                if(head != null) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    head = newNode;
                }
                num = 1;
                idx = 1;
            }

            Node cur = head;
            // idx만큼 이동
            for (int i = 1; i < idx ; i++)
                cur = cur.next;

            // nums 추가
            for (int i = num; i < nums.length ; i++) {
                Node newNode = getNewNode(nums[i]);
                newNode.next = cur.next;
                cur.next = newNode;
                cur = newNode;
            }

            if(cur.next == null)
                tail = cur;
        }

        // idx 부터 cnt 개 만큼 삭제
        void delete(int idx, int cnt) {
            Node cur = head;
            if(idx == 0) {
                // head부터 삭제되는 경우
                for (int i = 0; i < cnt; i++)
                    cur = cur.next;

                head = cur;
                return;
            }

            for (int i = 1; i < idx; i++)
                cur = cur.next;

            Node anchor = cur; // 삭제되기 직전 위치 기억하기
            for (int i = 0; i < cnt; i++)
                    cur = cur.next;

            anchor.next = cur.next;
            if (anchor.next == null)
                tail = anchor;
        }

        void add(int data) {
            Node cur = tail;
            Node newNode = getNewNode(data);
            cur.next = newNode;
            tail = newNode;
        }

        void print() {
            int cnt  =10;
            Node cur = head;
            while(--cnt >=0) {
                sb.append(cur.data).append(' ');
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        for (int tc = 1; tc <= 10; tc++) {
            LinkedList list = new LinkedList();
            sb.append('#').append(tc).append(' ');

            int n = Integer.parseInt(br.readLine());
            int[] init = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                init[i] = Integer.parseInt(st.nextToken());
            }
            list.insert(0, init);

            int cmdCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cmdCount; i++) {
                char cmd = st.nextToken().charAt(0);
               int x,y;
               switch (cmd) {
                   case 'I':
                       x = Integer.parseInt(st.nextToken());
                       y = Integer.parseInt(st.nextToken());
                       int[] temp = new int[y];
                       for (int j = 0; j < y; j++) {
                           temp[j] = Integer.parseInt(st.nextToken());
                       }
                       list.insert(x, temp);
                       break;
                   case 'D' :
                       x = Integer.parseInt(st.nextToken());
                       y = Integer.parseInt(st.nextToken());
                       list.delete(x, y);
                       break;
                   case 'A' :
                       y = Integer.parseInt(st.nextToken());
                       for (int j = 0; j < y; j++) {
                           list.add(Integer.parseInt(st.nextToken()));
                       }
                       break;
               }
            }
            list.print();
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
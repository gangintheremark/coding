import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	private static int n;
	private static Node[] nodes;
	private static boolean isVisited[];
	private static boolean flag;
	private static int myCoin;

	private static class Node {
		String mode;
		int coin;
		ArrayList<Integer> goRoom;

		public Node(String mode, int coin) {
			this.mode = mode;
			this.coin = coin;
			goRoom = new ArrayList<>();
		}
	}

	public static void main(String[] args) throws IOException {

		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			nodes = new Node[n + 1];
			isVisited = new boolean[n + 1];
			flag = false;
			myCoin = 0;

			// E 빈 방, L 레프리콘, T 트롤
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				int coin = Integer.parseInt(st.nextToken());

				nodes[i] = new Node(str, coin);

				while (true) {
					int room = Integer.parseInt(st.nextToken());
					if (room == 0)
						break;
					nodes[i].goRoom.add(room);
				}
			}

			// 1번 방에서 n번방 갈 수 있는지
			if (nodes[1].mode.equals("L")) {
				myCoin = nodes[1].coin;
				dfs(1);
			} else if(nodes[1].mode.equals("E")) {
				dfs(1);
			}


			sb.append(flag ? "Yes" : "No").append('\n');
		}
		System.out.println(sb);
	}

	public static void dfs(int start) {
		if (start == n) {
			flag = true;
			return;
		}

		for (int i = 0; i < nodes[start].goRoom.size(); i++) {
			int room = nodes[start].goRoom.get(i);
			Node now = nodes[room];

			if (now.mode.equals("E") && !isVisited[room]) {
				isVisited[room] = true;
				dfs(room);
				isVisited[room] = false;
			} else if (now.mode.equals("L") && !isVisited[room]) {
				int tmp = myCoin;
				if (now.coin > myCoin)
					myCoin = now.coin;
				isVisited[room] = true;
				dfs(room);
				isVisited[room] = false;
				myCoin = tmp;
			} else if (now.mode.equals("T") && !isVisited[room]) {
				int tmp = myCoin;
				if (now.coin <= myCoin) {
					myCoin -= now.coin;
					isVisited[room] = true;
					dfs(room);
					isVisited[room] = false;
					myCoin = tmp;
				}
			}
		}
	}

}
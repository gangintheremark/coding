import java.io.*;
import java.util.*;

public class Main {
	
	static int getDist(int[] pos1, int[] pos2) {
		return Math.abs(pos1[0]-pos2[0]) + Math.abs(pos1[1]-pos2[1]);
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		nextCase : for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			boolean[][] adj = new boolean[n+2][n+2];
			int[][] pos = new int[n+2][2];
			
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				pos[i] = new int[] {x,y};
				
				for(int j=0; j<i; j++) {
					int dist = getDist(pos[j], pos[i]);
					// 좌표 간 거리 계산 후 1000m(50m*20병) 이하인 간선만 입력
					if(dist<=1000) {
						adj[i][j]=true;
						adj[j][i]=true;
					}
				}
			}
			
			boolean[] visited = new boolean[n+2];
			
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			visited[0]=true;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int i=0; i<n+2; i++) {
					if(adj[cur][i] && !visited[i]) {
						visited[i] = true;
						q.add(i);
					}
				}
				
				if(visited[n+1]) {
					System.out.println("happy");
					continue nextCase;
				}
			}
			System.out.println("sad");
			
		}
	}

}

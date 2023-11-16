import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int n, m, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n+1];
        long[] Tree = new long[n+1];
        for(int i=1;i<=n;i++) {
            arr[i] = Long.parseLong(br.readLine());
            update(Tree, i, arr[i]);
        }

        for(int i=0;i<m+k;i++) {
            st = new StringTokenizer(br.readLine().trim());
            int num = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            long val = Long.parseLong(st.nextToken());
            if(num == 1) {
                long _diff = val - arr[idx];
                arr[idx] = val;
                update(Tree, idx, _diff);
            }
            else {
                int end = (int)val;
                System.out.println(sum(Tree,end) - sum(Tree, idx-1));
            }
        }
    }

    public static void update(long[] tree, int i, long diff) {
        while(i<tree.length) {
            tree[i] += diff;
            i += (i&-i);
        }
    }

    public static long sum(long[] tree, int i) {
        long ans = 0;
        while(i>0) {
            ans += tree[i];
            i -= (i&-i);
        }
        return ans;
    }
}


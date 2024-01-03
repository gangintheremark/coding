import java.util.*;

public class Solution {
    
    static int n,m;
    static int[] a;
    static int[] b;
    
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       
       int T = s.nextInt();
       
       for(int t = 0; t < T ; t++) {
        
        n = s.nextInt();
        m = s.nextInt();
        
        a = new int[n];
        b = new int[m];
        
        for(int i=0;i<n;i++) {
            a[i] = s.nextInt();
        }
        for(int i=0;i<m;i++) {
            b[i] = s.nextInt();
        }
        
        int diff = Math.abs(n-m);
        int sum = 0;
        int max = 0;
        if(n < m) {
            for(int i = 0; i <= diff; i++){
                sum = 0;
                for(int j=0; j<n && j+i<m;j++) {
                    sum += a[j] * b[j+i]; 
                }
                if(sum > max) {
                    max = sum;
                }
            }
        } else {
             for(int i = 0; i <= diff; i++){
                 sum = 0;
                for(int j=0; j<m && j+i<n;j++) {
                    sum += b[j] * a[j+i]; 
                }
                if(sum > max) {
                    max = sum;
                }
            }
        }
        
        System.out.println("#" + (t+1) + " " + max);
       }
    }

}
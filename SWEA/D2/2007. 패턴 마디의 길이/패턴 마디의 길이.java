import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            boolean flag = false;
            String str = s.next();
            String temp="";
            temp += str.charAt(0);

            for (int j = 1; j < str.length(); j++) {

                if(str.charAt(j) == temp.charAt(0)) {
                    int t = 1;
                    for (int k = j+1; k < temp.length()+j; k++) {
                        if(str.charAt(k) != temp.charAt(t++)) {
                            break;
                        }
                        if(k==temp.length()+j-1) {
                            System.out.println("#"+ (i+1) + " " + temp.length());
                            flag = true;
                            break;
                        }
                    }
                    if(flag) {
                        break;
                    }
                }
                temp += str.charAt(j);
            }
        }

    }
}

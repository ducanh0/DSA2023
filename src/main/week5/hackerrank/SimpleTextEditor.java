import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner io = new Scanner(System.in);

        int q = io.nextInt();
        String s = "" ;
        Stack<String> ss = new Stack<String>();

        while (q > 0) {
            int type = io.nextInt();

            switch (type) {
                case 1 : {
                    String s2 = io.nextLine(); s2 = s2.trim();
                    ss.push(s);
                    s += s2 ;
                    break;
                }
                case 2 : {
                    int k = io.nextInt();
                    ss.push(s);
                    s = s.substring(0, s.length() - k);
                    break;
                }
                case 3 : {
                    int k = io.nextInt();
                    System.out.println(s.charAt(k - 1));
                    break;
                }
                case 4 : {
                    s = ss.peek(); ss.pop();
                    break;
                }
                default:
                    break;
            }

            q -- ;
        }
    }
}

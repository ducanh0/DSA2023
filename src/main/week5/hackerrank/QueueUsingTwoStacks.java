
import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner io = new Scanner(System.in);
        Stack<Integer> s1 = new Stack<>() , s2 = new Stack<>();
        int q = io.nextInt();

        while (q > 0){
            int type = io.nextInt();

            switch (type){
                case 1 : {
                    int x = io.nextInt();
                    s1.push(x);

                    break;
                }
                case 2 : {
                    if(s2.empty()){
                        while (! s1.empty()){
                            s2.push(s1.peek());
                            s1.pop();
                        }
                    }
                    s2.pop();
                    break;
                }
                case 3 : {
                    if(s2.empty()){
                        while (! s1.empty()){
                            s2.push(s1.peek());
                            s1.pop();
                        }
                    }
                    System.out.println(s2.peek());
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + type);
            }
            q -- ;
        }
    }
}
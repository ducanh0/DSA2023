import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Boolean> m = new HashMap<>();

        int ans = 0;

        for(int i : arr){
            if(m.containsKey(i - k)){
                ans ++;
            }

            if(m.containsKey(i + k)){
                ans ++;
            }

            m.put(i, true);
        }

        return ans;
    }

    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int n = io.nextInt(), k = io.nextInt();

        List<Integer> l = new ArrayList<>();

        while (n -- > 0){
            int val = io.nextInt();

            l.add(val);
        }

        System.out.println(pairs(k, l));
    }
}

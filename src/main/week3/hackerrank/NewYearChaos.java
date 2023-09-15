import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    static int [] bit = new int [100002] ;
    static int n ;

    public static void upd(int idx){
        while(idx <= n) {
            bit[idx] ++ ;
            idx += (idx & (-idx));
        }
    }

    public static int get(int idx){
        int ans = 0 ;
        while(idx > 0){
            ans += bit[idx] ;
            idx -= (idx & (-idx));
        }
        return ans ;
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        // voi moi thang i -> dem so thang co id nho hon no ma nam sau no
        n = q.size() ;
        for(int i = 1;i <= n;i ++) {
            bit[i] = 0;
        }

        int ans = 0 ;
        for(int i = q.size() - 1 ; i >= 0 ; i --){
            int x = get(q.get(i));

            if(x > 2){
                System.out.println("Too chaotic");
                i = -1 ;
                ans = -1;
            } else {
                ans += x ;
                upd(q.get(i));
            }
        }
        if(ans != -1){
            System.out.println(ans);
        }

    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

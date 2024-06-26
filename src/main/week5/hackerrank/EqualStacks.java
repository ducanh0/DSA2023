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
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> ss = new Stack<Integer>();

        for(int i = h1.size() - 1, sum = 0 ; i >= 0;i --){
            sum += h1.get(i);

            ss.push(sum);
        }

        for(int i = 0;i < h1.size();i ++){
            h1.set(i, ss.peek());
            ss.pop();
        }

        for(int i = h2.size() - 1, sum = 0 ; i >= 0;i --){
            sum += h2.get(i);

            ss.push(sum);
        }

        for(int i = 0;i < h2.size();i ++){
            h2.set(i, ss.peek());
            ss.pop();
        }

        for(int i = h3.size() - 1, sum = 0 ; i >= 0;i --){
            sum += h3.get(i);

            ss.push(sum);
        }

        for(int i = 0;i < h3.size();i ++){
            h3.set(i, ss.peek());
            ss.pop();
        }

        int i1 = 0 , i2 = 0, i3 = 0 ;
        while ((i1 < h1.size()) &&
                (i2 < h2.size()) &&
                (i3 < h3.size())){

            int minVal = Math.min(Math.min( h2.get(i2),h3.get(i3) ), h1.get(i1));

            while ((i1 < h1.size()) && (h1.get(i1) > minVal)) i1 ++ ;
            while ((i2 < h2.size()) && (h2.get(i2) > minVal)) i2 ++ ;
            while ((i3 < h3.size()) && (h3.get(i3) > minVal)) i3 ++ ;

            boolean ok = true;
            if((i1 < h1.size()) && (h1.get(i1) == minVal));
            else ok = false;

            if((i2 < h2.size()) && (h2.get(i2) == minVal));
            else ok = false;

            if((i3 < h3.size()) && (h3.get(i3) == minVal));
            else ok = false;

            if(ok){
                return minVal;
            }
        }

        return 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

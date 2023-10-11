
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



    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0;i < A.size();i ++){
            pq.add(A.get(i));
        }

        int d = 0;

        while (pq.size() > 1){
            int u = pq.peek();

            if(u < k) {
                pq.poll();
                int v = pq.poll() * 2 + u ;
                d ++ ;
                pq.add(v);
            }
            else {
                break;
            }
        }

        return ((pq.peek() >= k) ? d : -1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

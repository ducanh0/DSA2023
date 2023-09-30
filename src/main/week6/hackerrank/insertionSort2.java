
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
 * Complete the 'insertionSort2' function below.
 *
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY arr
 */

public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for(int i = 1;i < n;i ++){
        for(int j = i - 1; j >= -1;j --){
        if(j == -1 || arr.get(j) <= arr.get(i)){
        int idx = i ;
        while (idx > j + 1){
        int temp = arr.get(idx - 1) ;
        arr.set(idx - 1 , arr.get(idx));
        arr.set(idx , temp);

        idx -- ;
        }
        break;
        }
        }
        for(int j = 0;j < n;j ++){
        System.out.print(arr.get(j) + " ");
        }
        System.out.println();
        }
        }

        }

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}


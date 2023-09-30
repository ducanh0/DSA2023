
import java.io.*;
import java.util.*;

public class Solution {

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

        }
    }

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();

        List<Integer> arr = new ArrayList<>();

        for(int  i = 0;i < n;i ++){
            arr.add(io.nextInt());
        }

        insertionSort2(n , arr);

        for(int j = 0;j < n;j ++){
            System.out.print(arr.get(j) + " ");
        }
        //  System.out.println();
    }
}

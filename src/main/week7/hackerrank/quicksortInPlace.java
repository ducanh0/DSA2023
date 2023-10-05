
 import java.io.*;
import java.util.*;

public class Solution {
    static void sol(int idx1, int idx2, int [] arr){
        //   System.out.println(idx1 + " " + idx2);
        int sl = 0 ; // sl element < pivot

        for(int i = idx1 ; i < idx2 ; i ++){
            if(arr[i] < arr[idx2]) {

                int temp = arr[idx1 + sl];
                arr[idx1 + sl] = arr[i];
                arr[i] = temp;

                sl ++ ;
            }
            else ;
        }

        int temp = arr[idx1 + sl];
        arr[idx1 + sl] = arr[idx2];
        arr[idx2] = temp;

        for(int i = 0;i < arr.length;i ++){
            System.out.print(arr[i] + " ");
            //   System.out.println("??");
        }

        System.out.println();


        if(sl > 1) {
            sol(idx1, idx1 + sl - 1, arr);
        }

        if(idx2 - idx1  - sl > 1) {
            sol(idx1 + sl + 1, idx2, arr);
        }


    }

    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();

        //System.out.println(n);

        int [] arr = new int [n];

        for(int i = 0;i < n;i ++) {
            arr[i]  = io.nextInt();
        }

        if(n > 1)
            sol(0, n - 1, arr) ;
    }


}

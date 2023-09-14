import java.util.Arrays;

import static java.lang.Math.*;

public class _3_2_binary_search {
    public static int binarySearch(int[] a, int number){
        if((a[0] > number) || (a[a.length - 1] < number)){
            return -1;
        }

        int l = 0 ;
        int r = a.length - 1;

        while (l <= r){
            int mid = (l + r) / 2;

            if(a[mid] <= number){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ((a[r] == number) ? r : -1);
    }

    public static void main(String [] args){
        int MAX_VALUE = 1000000000 ;
        int MAX_N = 1000000 ;

        int [] arr = new int[MAX_N];

        for(int i = 0;i < MAX_N;i ++){
            arr[i] = (int)(MAX_VALUE * random());
            
        }

        Arrays.sort(arr, 0, MAX_N);

        System.out.println(binarySearch(arr, arr[MAX_N / 2 ]));

        System.out.println(binarySearch(arr, arr[0] - 1));
    }
}

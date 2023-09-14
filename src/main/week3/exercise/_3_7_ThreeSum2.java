import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class _3_7_ThreeSum2 {
    public static void main(String [] args){
        int n = 0 ;
        int [] arr = new int[1000] ;

        while (! StdIn.isEmpty()){
            arr[n] = StdIn.readInt();
            n ++ ;
        }

        Arrays.sort(arr, 0, n);

        int slKhacNhau = 0, val = arr[0] - 1;

        for(int i = 0 ; i < n;i ++) {
            if(arr[i] != val){
                slKhacNhau ++ ;
                val = arr[i];
            }
        }

        int [] a = new int[slKhacNhau] ;

        for(int i = 0 ;i < slKhacNhau;i ++){
            a[i] = 0;
        }

        int i = 0 , j , id = 0;
        while (i < n){
            j = i ;
            while ((j < n) && (arr[j] == arr[i])){
                j ++ ;
            }
            a[id] = j - i ;
            arr[id] = arr[i] ;
            id ++ ;
            i = j ;
        }

        n = id ;

        int ans = 0;

        for(  i = 0;i < n ; i ++){
            if((arr[i] == 0) && (a[i] >= 3)){

                ans += a[i] * (a[i] - 1) * (a[i] - 2) / 6;

            }

             j = 0 ;
            int k = n - 1;

            while ((j < i) && (i < k)){
                int sum = arr[i] + arr[j] + arr[k] ;

                if(sum == 0){
                    ans += a[i] * a[j] * a[k];
                } else {
                    if(sum < 0){
                        j ++ ;
                    } else {
                        k -- ;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}

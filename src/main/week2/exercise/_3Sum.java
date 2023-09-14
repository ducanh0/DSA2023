import edu.princeton.cs.algs4.*;
public class _3Sum {
    public static void main(String [] args){
        int n = 0 ;
        int [] arr = new int[500] ;

        while (! StdIn.isEmpty()){
            arr[n] = StdIn.readInt();
            n ++ ;
        }

        for(int i = 0;i < n;i ++){
            for(int j = i + 1;j < n;j ++){
                for(int k = j + 1;k < n;k ++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    }
                }
            }
        }

    }
}

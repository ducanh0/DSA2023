import edu.princeton.cs.algs4.*;
public class _2Sum {
    public static void main(String [] args){
        int n = 0 ;
        int [] arr = new int[1000] ;

        while (! StdIn.isEmpty()){
            arr[n] = StdIn.readInt();
            n ++ ;
        }

        for(int i = 0;i < n;i ++){
            for(int j = i + 1;j < n;j ++){
                if(arr[i] + arr[j] == 0){
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }

    }
}

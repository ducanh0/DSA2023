import edu.princeton.cs.algs4.In;

import java.util.*;

public class missingNumber {
    private static class order implements Comparator<Integer>{
        @Override
        public int compare(Integer a,Integer b){
            return Integer.compare(a, b);
        }
    }
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> tmp = arr;
        arr = brr;
        brr = tmp;

        arr.sort(new order());
        brr.sort(new order());

        //for(int i : brr)System.out.print(i + " ");

        int i = 0 , j , i1 = 0 , j1 ;

        List<Integer> ans = new ArrayList<>();

        while (i < arr.size()){
           // System.out.print("  " + arr.get(i) );
            j = i ;
            while (j < arr.size() && arr.get(j).equals(arr.get(i))) j ++ ;

            while (i1 < brr.size() && brr.get(i1) < arr.get(i)) i1 ++;

            if(i1 == brr.size() || ! brr.get(i1).equals( arr.get(i))){
                ans.add(arr.get(i));

            } else {
                j1 = i1 ;

                while (j1 < brr.size() && brr.get(j1).equals(brr.get(i1))) j1 ++;

                if(j1 - i1 != j - i){
                    ans.add(arr.get(i));

                }
                    i1 = j1 ;

            }

            i = j ;
        }

        return ans;
    }

    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();

        List<Integer> arr = new ArrayList<>();

        while (n --  > 0){
            int v = io.nextInt();

            arr.add(v);
        }

        int m = io.nextInt();

        List<Integer> brr = new ArrayList<>();

        while (m --  > 0){
            int v = io.nextInt();

            brr.add(v);
        }


        List<Integer> ans = missingNumbers(arr, brr);

        for(int i : ans)
            System.out.print(i + " ");
    }
}

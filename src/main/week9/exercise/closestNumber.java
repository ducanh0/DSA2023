import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class closestNumber {
    private static List<Integer> left = new ArrayList<>(), right = new ArrayList<>();

    public static void sort(List<Integer> arr, int l, int r){

        if(l >= r) return ;

        int mid = (l + r) / 2;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        for(int i = l;i <= mid;i ++){
            left.add(arr.get(i));
        }

        for(int i = mid + 1;i <= r;i ++){
            right.add(arr.get(i));
        }

        // merge
        int id = l;
        while (! left.isEmpty() || ! right.isEmpty()){
            if(left.isEmpty()){
                while (! right.isEmpty()) {
                    arr.set(id, right.remove(0));
                    id ++;
                }

                break;
            }

            if(right.isEmpty()){
                while (! left.isEmpty()) {
                    arr.set(id, left.remove(0));
                    id ++;
                }

                break;
            }

            if(left.get(0) <= right.get(0)){
                arr.set(id, left.remove(0));
            } else {
                arr.set(id, right.remove(0));
            }

            id ++;
        }
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        sort(arr, 0, arr.size() - 1);

        List<Integer> ans = new ArrayList<>();

        int minDiff = Integer.MAX_VALUE;

        for(int i = 1;i < arr.size();i ++){
            minDiff = Math.min(minDiff, arr.get(i) - arr.get(i - 1));

            if((i == arr.size() - 1) && (arr.get(i) == arr.get(0))){
                minDiff = 0;
            }
        }

        for(int i = 1;i < arr.size();i ++){
            if(minDiff == arr.get(i) - arr.get(i - 1)){
                ans.add(arr.get(i -1));
                ans.add(arr.get(i));
            }
            if((i == arr.size() - 1) && (arr.get(i) == arr.get(0))){
                ans.add(arr.get(0));
                ans.add(arr.get(0));
            }

        }

        return ans ;
    }

    public static void main(String [] args){
        List<Integer> arr = new ArrayList<>();

        Scanner io = new Scanner(System.in);

        int n = io.nextInt();

        while (n -- > 0){
            int v = io.nextInt();

            arr.add(v);
        }


        List<Integer> ans = closestNumbers(arr);

        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}

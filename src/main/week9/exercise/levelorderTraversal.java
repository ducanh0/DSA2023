import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class levelorderTraversal {
    private static ArrayList<Integer> arr = new ArrayList<>();
    private static HashMap<Integer, Integer> m = new HashMap<>();

    private static class Node {
        private int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public void setVal(int val){
            this.val = val;
        }

        public int getVal(){
            return val;
        }
    }

    public static void add(Node a, int val,int t){
        if(a.getVal() == 0){
            a.setVal(val);

            arr.add(val);
            m.put(val, t);

            return;
        }

        if(val < a.val){
            if(a.left == null){
                a.left = new Node(0);
            }

            add(a.left, val, t + 1);
        } else {
            if(a.right == null){
                a.right = new Node(0);
            }

            add(a.right, val, t + 1);
        }
    }

    private static class customOrder implements Comparator<Integer> {
        @Override
        public int compare(Integer a,Integer b){
            int ta = m.get(a), tb = m.get(b);

            if(ta == tb) return Integer.compare(a, b);
            return Integer.compare(ta, tb);
        }
    }

    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();

        Node root = new Node(0);

        while (n -- > 0){
            int val = io.nextInt();

            add(root, val, 0);
        }

       arr.sort(new customOrder());

        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}

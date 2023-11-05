import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lcaBST {
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

    private static int [] p = new int [30];
    private static int [] tang = new int [30];

    public static void add(Node a, int val,int pre,int t){
        if(a.getVal() == 0){
            p[val] = pre;
            tang[val] = t;

            a.setVal(val);
            return;
        }

        if(val < a.val){
            if(a.left == null){
                a.left = new Node(0);
            }

            add(a.left, val, a.val, t  + 1);
        } else {
            if(a.right == null){
                a.right = new Node(0);
            }

            add(a.right, val, a.val, t + 1);
        }
    }

    private static boolean isCha(int a,int b){
        while (b != 0){
            if(b == a) return true;

            b = p[b];
        }

        return false;
    }

    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();

        for(int i = 0;i < 30;i ++){
            p[i] = 0;
            tang[i] = 0;
        }

        Node root = new Node(0);

        while (n -- > 0){
            int val = io.nextInt();

            add(root, val, 0, 0);
        }

        int u = io.nextInt() , v = io.nextInt();
        int ans = -1;

        for(int i = 1;i < 30;i ++){
          //  System.out.println("??" + p[i] + " " + tang[i]);

            if(isCha(i, u) && isCha(i, v)){
                if(ans == -1 || tang[ans] < tang[i]){
                    ans = i;
                }
            }
        }

        System.out.println(ans);
    }
}

import java.util.Scanner;

public class treeHeight {
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

    public static void add(Node a,int val){
        if(a.getVal() == 0){
            a.setVal(val);
            return;
        }

        if(val < a.val){
            if(a.left == null){
                a.left = new Node(0);
            }

            add(a.left, val);
        } else {
            if(a.right == null){
                a.right = new Node(0);
            }

            add(a.right, val);
        }
    }

    public static int getHeight(Node a,int h){
        if(a == null){
            return 0;
        }

        return Math.max(h, Math.max(getHeight(a.left, h + 1), getHeight(a.right, h + 1)));
    }

    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();

        Node root = new Node(0);

        while (n -- > 0){
            int val = io.nextInt();

            add(root, val);
        }

        System.out.println(getHeight(root, 0));
    }
}

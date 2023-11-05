import java.util.Scanner;

public class inorderTraveral {

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

    public static void add(Node a, int val){
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

    public static void inOrder(Node a){
        if(a.left != null){
            inOrder(a.left);
        }

        System.out.print(a.getVal() + " ");

        if(a.right != null){
            inOrder(a.right);
        }
    }

    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();

        Node root = new Node(0);

        while (n -- > 0){
            int val = io.nextInt();

            add(root, val);
        }

        inOrder(root);
    }
}

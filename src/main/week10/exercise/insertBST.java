import java.util.Scanner;

public class insertBST {
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

    static Node insert(Node root, int data){
        add(root, data);

        return root;
    }

    public static void preOrder(Node a){

        System.out.print(a.getVal() + " ");

        if(a.left != null){
            preOrder(a.left);
        }

        if(a.right != null){
            preOrder(a.right);
        }
    }

    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();

        Node root = new Node(0);

        while (n -- > 0){
            int val = io.nextInt();

            insert(root, val);
        }

        preOrder(root);
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solver {
    private  int ans = -1;

     private class Node {
        private int d ;

        private Board a;
        private Node pre;

        public Node(Board other){
            if(other == null){
                throw new IllegalArgumentException();
            }

            a = other;
        }

        public void setA(Board other){
            if(other == null){
                throw new IllegalArgumentException();
            }

            a = other;
        }

        public void setD(int d){
            this.d = d;
        }

        public void setPre(Node other){
            if(other == null){
                throw new IllegalArgumentException();
            }

            pre = other;
        }
    }

    private Node root;

    private ArrayList<Integer> tv = new ArrayList<>();
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial){
        if(initial == null){
            throw new IllegalArgumentException();
        }

        root = new Node(initial);
        if(initial.isGoal()){
            ans = 0;
        } else {

            root.setD(0);
            tv.add(root.a.finalHash);

          //  System.out.println("ok");

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (! q.isEmpty()) {
                Node u = q.remove();
               // System.out.println(u.a.toString() + "\n-----------------\n");
                Iterable<Board> it = u.a.neighbors();

                for (Board v : it) {
                    if (tv.contains(v.finalHash)) {
                       // System.out.println("ok");
                        continue;
                    }

                    Node newNode = new Node(v);
                    newNode.setD(u.d + 1);
                    newNode.setPre(u);

                    if (newNode.a.isGoal()) {
                        ans = newNode.d;
                        tv.clear();

                        while (true) {
                            tv.add(newNode.a.truyVet);
                            newNode = newNode.pre;

                            if (newNode.a.equals(initial)) break;
                        }
                    } else {
                        tv.add(v.finalHash);

                        q.add(newNode);
                    }
                }
             //   System.out.println("ok");
            }
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable(){
        return (ans >= 0);
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves(){
        return ans;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution(){
        ArrayList<Board> trace = new ArrayList<>();
        int id = tv.size();

        trace.add(root.a);

        while (id > 0){
            root.setA(root.a.twin(tv.get(id - 1)));
            trace.add(root.a);

            id --;
        }

        return trace;
    }

    // test client (see below)
    public static void main(String[] args){
       /* int [][] ar = {{ 1, 2,3} , {4, 5, 6}, {7, 8, 0}};
        Board kltm = new Board(ar) ;//, kl = new Board(ar);
      //  System.out.println(kltm.isGoal());
     //   System.out.println("ok");
        Solver sol = new Solver(kltm);
       // System.out.println("ok");
        Iterable<Board> it = sol.solution();

        for(Board i : it){
            System.out.println(i.toString());
            System.out.println("-------------------");
        }*/
    }
}

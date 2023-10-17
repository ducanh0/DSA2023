import edu.princeton.cs.algs4.MinPQ;

import java.util.Deque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class Solver {
    private  int ans = -1;

     private class Node implements Comparable<Node> {
        private Board a;
        private Node pre;

        public int mah, move ;

        public Node(Board other,int move){
            if(other == null){
                throw new IllegalArgumentException();
            }

            a = other;
            mah = a.manhattan();
            this.move = move ;
        }

        @Override
         public int compareTo(Node other){
            return Integer.compare(mah + move , other.mah + other.move);
        }
    }

     private Deque<Board> trace = new ArrayDeque<>();

  //  private ArrayList<String> tv = new ArrayList<>();
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial){
        if(initial == null){
            throw new IllegalArgumentException();
        }


        if(initial.isGoal()){
            ans = 0;
        } else {

            Node root = new Node(initial, 0);
           // tv.add(root.a.toString());

          //  System.out.println("ok");

           // Queue<Node> q = new LinkedList<>();
          //  q.add(root);

            MinPQ<Node> pq = new MinPQ<>();
            pq.insert(root);

            int dem = 1;
            boolean ok = true;

            while (! pq.isEmpty() && ok) {
                root = pq.delMin();
                dem ++ ;
                if(dem == 10000000){
                    ans = -1; ok = false;
                    break;
                }
               // System.out.println(u.a.toString() + "\n-----------------\n");
                Iterable<Board> it = root.a.neighbors();

                Board pre = null;
                if(root.pre != null) pre = root.pre.a;

                for (Board v : it) {
                    if( v.equals(pre)) continue;

                    Node newNode = new Node(v, root.move + 1);

                    newNode.pre = root;

                    if (newNode.a.isGoal()) {
                    //    System.out.println("ok");

                    //    q.clear();


                        while (true) {
                            if (newNode.a.equals(initial)) break;

                            trace.addFirst(newNode.a);
                         //   tv.add(newNode.a.truyVet);
                            newNode = newNode.pre;
                        }
                        ans = trace.size();
                        ok = false;
                        break;
                    } else {
                       // tv.add(ss);

                        pq.insert(newNode);
                        dem ++ ;
                        if(dem == 10000000){
                            ans = -1; ok = false;
                            break;
                        }
                    }
                }
             //   System.out.println("ok");
            }
        }
        trace.addFirst(initial);

      //  MinPQ<Board> pq = new MinPQ<>();
      //  initial.manhattan();
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable(){
        return (ans >= 0);
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves(){
        if(! isSolvable()) return -1;
        return ans;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution(){
        if(! isSolvable()) return null;
        return trace;
    }

    // test client (see below)
    public static void main(String[] args){
      int [][] ar = {{ 5, 2, 6} , {1, 4, 3}, {8, 0, 7}};
        Board kltm = new Board(ar) ;//, kl = new Board(ar);
      //  System.out.println(kltm.isGoal());
     //   System.out.println("ok");
        Solver sol = new Solver(kltm);
       // System.out.println("ok");
        Iterable<Board> it = sol.solution();
        System.out.println("??" + sol.moves());
        for(Board i : it){
            System.out.println(i.toString());
            System.out.println("-------------------");
        }
    }
}

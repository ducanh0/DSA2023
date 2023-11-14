import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;

public class SAP {
    private Digraph graph;
    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G){
        graph = new Digraph(G);
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w){
        BreadthFirstDirectedPaths g1 = new BreadthFirstDirectedPaths(graph, v),
                g2 = new BreadthFirstDirectedPaths(graph, w);

        int ans = Integer.MAX_VALUE;//, id = -1;

        for(int i = 0;i < graph.V();i ++){
            if(g1.hasPathTo(i) && g2.hasPathTo(i)){
                int d = g1.distTo(i) + g2.distTo(i);

                if(d < ans){
                    ans = d;
                  //  id = i;
                }
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w){
        BreadthFirstDirectedPaths g1 = new BreadthFirstDirectedPaths(graph, v),
                g2 = new BreadthFirstDirectedPaths(graph, w);

        int ans = Integer.MAX_VALUE, id = -1;

        for(int i = 0;i < graph.V();i ++){
            if(g1.hasPathTo(i) && g2.hasPathTo(i)){
                int d = g1.distTo(i) + g2.distTo(i);

                if(d < ans){
                    ans = d;
                      id = i;
                }
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : id;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w){
        BreadthFirstDirectedPaths g1 = new BreadthFirstDirectedPaths(graph, v),
                g2 = new BreadthFirstDirectedPaths(graph, w);

        int ans = Integer.MAX_VALUE;//, id = -1;

        for(int i = 0;i < graph.V();i ++){
            if(g1.hasPathTo(i) && g2.hasPathTo(i)){
                int d = g1.distTo(i) + g2.distTo(i);

                if(d < ans){
                    ans = d;
                    //  id = i;
                }
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w){
        BreadthFirstDirectedPaths g1 = new BreadthFirstDirectedPaths(graph, v),
                g2 = new BreadthFirstDirectedPaths(graph, w);

        int ans = Integer.MAX_VALUE, id = -1;

        for(int i = 0;i < graph.V();i ++){
            if(g1.hasPathTo(i) && g2.hasPathTo(i)){
                int d = g1.distTo(i) + g2.distTo(i);

                if(d < ans){
                    ans = d;
                    id = i;
                }
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : id;
    }

    // do unit testing of this class
    public static void main(String[] args){

    }
}

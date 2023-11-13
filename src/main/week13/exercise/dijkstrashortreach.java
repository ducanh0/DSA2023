import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class dijkstrashortreach {
    private static class customOrder implements Comparator<List<Integer>>{
        @Override
        public int compare(List<Integer> a,List<Integer> b){
            int w1 = a.get(1), w2 = b.get(1);

            return Integer.compare(w1, w2);
        }
    }
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        int [] d = new int[n + 1] ;

        for(int i = 0;i <= n;i ++){
            d[i] = -1;

            if(i == s){
                d[i] = 0;
            }
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i <= n;i ++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i < edges.size();i ++){
            int u = edges.get(i).get(0),
                    v = edges.get(i).get(1),
                    w = edges.get(i).get(2);

            adj.get(u).add(v); adj.get(u).add(w);
            adj.get(v).add(u); adj.get(v).add(w);
        }

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new customOrder());

        List<Integer> l = new ArrayList<>();
        l.add(s); l.add(0);

        pq.add(l);

        while (! pq.isEmpty()){
            List<Integer> ll = pq.poll();

            int u = ll.get(0), w = ll.get(1);

            if(w != d[u]) continue;

            for(int i = 0;i < adj.get(u).size();i += 2){
                int v = adj.get(u).get(i),
                        ww = adj.get(u).get(i + 1);

                if(d[v] == -1 || d[v] > d[u] + ww){
                    d[v] = d[u] + ww;

                    List<Integer> lll = new ArrayList<>();
                    lll.add(v); lll.add(d[v]);

                    pq.add(lll);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 1;i <= n;i ++){
            if(i != s){
                ans.add(d[i]);
            }
        }

        return ans;
    }

}

import java.util.*;

public class primsmstsub {
    private static class customOrder implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> a, List<Integer> b){
            int w1 = a.get(2), w2 = b.get(2);

            return Integer.compare(w1, w2);
        }
    }

    public static int prims(int n, List<List<Integer>> edges, int start) {
        // Write your code here
        edges.sort(new customOrder());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i <= n; i ++ ){
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

        boolean [] ok = new boolean[n + 1];

        ok[start] = true;

        for(int i = 0;i < adj.get(start).size();i += 2) {
            int u = adj.get(start).get(i),
                    w = adj.get(start).get(i + 1);

            List<Integer> l = new ArrayList<>();

            l.add(start); l.add(u); l.add(w);

            pq.add(l);
        }

        int ans = 0;

        while (! pq.isEmpty()){
            List<Integer> l = pq.poll();

            int u = l.get(1), w = l.get(2);

            if(! ok[u]){
                ans += w;
                ok[u] = true;

                for(int i = 0;i < adj.get(u).size();i += 2){
                    int v = adj.get(u).get(i),
                            ww = adj.get(u).get(i + 1);

                    if(! ok[v]){
                        List<Integer> ll = new ArrayList<>();

                        ll.add(u); ll.add(v); ll.add(ww);

                        pq.add(ll);
                    }
                }
            }
        }

        return ans;
    }

//    public static void main(String [] args){
//        Scanner io = new Scanner(System.in);
//
//        int n = io.nextInt(), m = io.nextInt();
//
//
//    }
}

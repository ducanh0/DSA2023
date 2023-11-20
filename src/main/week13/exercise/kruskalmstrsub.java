import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class kruskalmstrsub {
    private static int [] par = new int [3002];

    private static int fPar(int u){
        while (par[u] > 0){
            u = par[u];
        }

        return u;
    }

    private static boolean union(int u, int v){
        u = fPar(u); v = fPar(v);

        if(u == v) return false;

        if(par[u] > par[v]){
            int tmp = u; u = v; v = tmp;
        }

        par[u] += par[v]; par[v] = u;

        return true;
    }

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        ArrayList<Integer> id = new ArrayList<>();

        for(int i = 0;i < gFrom.size();i ++){
            id.add(i);
        }

        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(gWeight.get(o1), gWeight.get(o2));
            }
        });

        for(int i = 0;i < gNodes;i ++){
            par[i] = -1;
        }

        int ans = 0;

        for(int i = 0;i < id.size();i ++){
            int idx = id.get(i), u = gFrom.get(idx),
            v = gTo.get(idx), w = gWeight.get(idx);

            if(union(u, v)){
                ans += w;
            }
        }

        return ans;
    }

    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int n = io.nextInt(), m = io.nextInt();

        List<Integer> u = new ArrayList<>(),
                v = new ArrayList<>(),
                w = new ArrayList<>();

        while (m -- > 0){
            int i = io.nextInt(), j = io.nextInt(), k = io.nextInt();

            u.add(i); v.add(j); w.add(k);
        }

        System.out.println(kruskals(n, u, v, w));
    }
}

/**
 * 4 6
 * 1 2 5
 * 1 3 3
 * 4 1 6
 * 2 4 7
 * 3 2 4
 * 3 4 5
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class bfs {
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i = 0;i <= n;i ++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i < edges.size();i ++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0;i <= n;i ++){
            if(i == s) ans.add(0);
            else ans.add(-1);
        }

        adj.get(0).add(s);

        while (! adj.get(0).isEmpty()){
            int u = adj.get(0).remove(0);

            for(int v : adj.get(u)){
                if(ans.get(v) == -1){
                    ans.set(v, 1 + ans.get(u));

                    adj.get(0).add(v);
                }
            }
        }

        ans.remove(s);
        ans.remove(0);

        for(int i = 0;i < ans.size();i ++){
            if(ans.get(i) != -1) ans.set(i, 6 * ans.get(i));
        }

        return ans;
    }

    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int q = io.nextInt();

        while (q -- > 0){
            int n = io.nextInt();
            int m = io.nextInt();


        }
    }
}

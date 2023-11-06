import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class roadsAndLibraries {

    private static int [] p = new int [100002];

    private static int fPar(int u){
        while (p[u] > 0){
            u = p[u];
        }

        return u;
    }

    private static void union(int u,int v){
        u = fPar(u) ; v = fPar(v);

        if(u == v) return;

        if(p[u] > p[v]) {
            int tmp = u ; u = v ; v = tmp;
        }

        p[u] += p[v]; p[v] = u;
    }

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        for(int i = 1;i <= n;i ++) {
            p[i] = -1;
        }

        for(int i = 0;i < cities.size();i++){
            int u = cities.get(i).get(0);
            int v = cities.get(i).get(1);

            // System.out.println("??" + u + " " + v);
            union(u, v);
        }
//
//            for(int i = 1;i <= n;i ++){
//                int j = fPar(i);
//
//              System.out.print(" " + j);
//            }

//            System.out.println("okk");
        if(c_lib <= c_road){
            return (long)n * (long)c_lib;
        } else {
            long ans = 0;
            //  System.out.println("okk");
            for(int i = 1;i <= n;i ++){
                int j = fPar(i);

                if(p[j] < 0){
                    ans += (long)c_lib + (long)c_road * (long)(-1 - p[j]);
                    p[j] = 0;
                }
            }

            return ans;
        }
    }

    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int q = io.nextInt();

        while (q -- > 0){
            int n = io.nextInt();
            int m = io.nextInt();

            int clib = io.nextInt();
            int croad = io.nextInt();

         //   System.out.println("??" +n + " "  + m +  " " + clib + " " + croad );

            for(int i = 1;i <= n;i ++) {
                p[i] = -1;
            }

            while (m -- > 0){
                int u = io.nextInt();
                int v = io.nextInt();

               // System.out.println("??" + u + " " + v);
                union(u, v);
            }
//
//            for(int i = 1;i <= n;i ++){
//                int j = fPar(i);
//
//              System.out.print(" " + j);
//            }

//            System.out.println("okk");
            if(clib <= croad){
                System.out.println(n * clib);
            } else {
                int ans = 0;
              //  System.out.println("okk");
                for(int i = 1;i <= n;i ++){
                    int j = fPar(i);

                    if(p[j] != 0){
                        ans += clib + croad * (-1 - p[j]);
                        p[j] = 0;
                    }
                }

                System.out.println(ans);
            }
        }
    }
}
/**
  2
  3 3 2 1
  1 2
  3 1
  2 3
  6 6 2 5
  1 3
  3 4
  2 4
  1 2
  2 3
  5 6
 */
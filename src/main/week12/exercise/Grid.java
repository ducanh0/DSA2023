import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Grid {
    /**
     * 2 3
     *
     * 0 1 2
     * 3 4 5
     */
    private static int ax2dto1d(int x, int y, int m){
        return x * m + y;
    }

    private static int ax1dtox(int id,int m){
        return (id - ax1dtoy(id, m)) / m;
    }

    private static int ax1dtoy(int id,int m){
        return id % m;
    }

    public static final int dx[] = {-1, 0, 0, 1, -1, -1, 1, 1};
    public static final int dy[] = {0, -1, 1, 0, -1, 1, -1, 1};

    private static boolean isInside(int x,int y,int n,int m){
        return ! ((x < 0) || (x >= n) || (y < 0) || (y >= m));
    }

    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        int n = matrix.size();
        int m = matrix.get(0).size();
        int ans = 0;

        for(int i = 0 ;i < n;i ++){
            for(int j = 0;j < m;j ++){
                int v = matrix.get(i).get(j);

                if(v != 1) continue;

                matrix.get(i).set(j, 0);

                int id = ax2dto1d(i, j, m);

                List<Integer> l = new ArrayList<>();
                l.add(id);

                int sl = 1;

                while (! l.isEmpty()){
                    int u = l.remove(0);

                    int x = ax1dtox(u, m), y = ax1dtoy(u, m);

                    for(int k = 0;k < 8;k ++){
                        int X = x + dx[k], Y = y + dy[k];

                        if(isInside(X, Y, n, m) && (matrix.get(X).get(Y) == 1)){
                            sl ++;
                            l.add(ax2dto1d(X, Y, m));

                            matrix.get(X).set(Y, 0);
                        }
                    }
                }

                ans = Math.max(ans, sl);
            }
        }

        return ans;
    }


    public static void main(String [] args){
        Scanner io = new Scanner(System.in);

        int n = io.nextInt(), m = io.nextInt();

        List<List<Integer>> arr = new ArrayList<>();

        for(int i = 0;i < n; ++i){
            List<Integer> l = new ArrayList<>();

            for(int j = 0;j < m;j ++){
                int v = io.nextInt();

                l.add(v);
            }

            arr.add(l);
        }

        System.out.println(connectedCell(arr));
    }
}

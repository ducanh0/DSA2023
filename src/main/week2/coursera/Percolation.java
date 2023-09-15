import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;

    private int[] h1 = {-1,
            0,
            0,
            1
    };
    private int[] h2 = {
            0,
            -1,
            1,
            0
    };
    private WeightedQuickUnionUF uf;

    private boolean[][] ok;

    /**
     * creates n-by-n grid, with all sites initially blocked.
     */

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.n = n;
            ok = new boolean[n][n];
            uf = new WeightedQuickUnionUF(n * n + 2);

            for(int i = 1;i <= n;i ++) {
                uf.union(getId(1, i), n * n);
                uf.union(getId(n  , i) , n * n + 1);
            }
        }
    }

    /**
     * check inside .
     */

    private boolean isInside(int row, int col) {
        if ((row < 1) || (row > n) || (col < 1) || (col > n)) {
            return false;
        }
        return true;
    }

    /**
     * anh xa mang 2 chieu -> 1 chieu.
     */

    private int getId(int x, int y) {
        return (x - 1) * n + (y - 1);
    }

    /**
     * is the site (row, col) open?
     */

    public boolean isOpen(int row, int col) {
        if (!isInside(row, col)) {
            throw new IllegalArgumentException();
        }
        return ok[row - 1][col - 1];
    }

    /**
     * opens the site (row, col) if it is not open already.
     */

    public void open(int row, int col) {
        if (!isInside(row, col)) {
            throw new IllegalArgumentException();
        }
        if (!isOpen(row, col)) {


            ok[row - 1][col - 1] = true;
            int u = getId(row, col);

            for (int i = 0; i < 4; i++) {
                int x = row + h1[i];
                int y = col + h2[i];

                if (isInside(x, y) && isOpen(x, y)) {
                    int v = getId(x, y);

                    if (uf.find(u) != uf.find(v)) {
                        uf.union(u, v);
                    }
                }
            }
        }
    }

    /**
     * is the site (row, col) full?
     */

    public boolean isFull(int row, int col) {
        if (!isInside(row, col)) {
            throw new IllegalArgumentException();
        }

        if (!isOpen(row, col)) {
            return false;
        }

        if (uf.find(getId(row, col)) == uf.find( n * n)) {
            return true;
        }

        return false;
    }

    /**
     * returns the number of open sites.
     */

    public int numberOfOpenSites() {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (isOpen(i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * does the system percolate?
     */

    public boolean percolates() {

            if (uf.find(n * n ) == uf.find( n * n + 1)) {
                return true;
            }

        return false;
    }

    /**
     * test client (optional).
     */

    public static void main(String[] args) {
        Percolation kltm = new Percolation(3);

        System.out.println(kltm.percolates());
    }
}
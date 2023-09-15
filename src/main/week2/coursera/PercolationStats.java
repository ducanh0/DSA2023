import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private int n;
    private int trials;
    private double[] x;

    private double CONFIDENCE_95 = 1.96;

    /**
     * perform independent trials on an n-by-n grid.
     */

    public PercolationStats(int n, int trials) {
        if ((n <= 0) || (trials <= 0)) {
            throw new IllegalArgumentException();
        } else {
            this.n = n;
            this.trials = trials;
            x = new double[trials];

            for (int i = 0; i < trials; i++) {
                Percolation kltm = new Percolation(n);

                int y = 0;

                while (!kltm.percolates()) {
                    int tdY = StdRandom.uniform(1, n + 1); // tdX * n + tdY = idx
                    int tdX = StdRandom.uniform(1, n + 1);

                    if(! kltm.isOpen(tdX, tdY)){
                        kltm.open(tdX , tdY);
                       y ++ ;
                    }
                }
                x[i] = (y * 1.0) / (n * n);
            }
        }
    }

    /**
     * sample mean of percolation threshold.
     */

    public double mean() {
        double ans = 0.0 ;
        for(int i = 0;i < trials;i ++){
            ans += x[i];
        }

        return ans  / trials;
    }

    /**
     * sample standard deviation of percolation threshold.
     */

    public double stddev() {
        double m = mean();
        double ans = 0.0;

        for(int i = 0;i < trials;i ++){
            ans += (x[i]  - m) * (x[i]  - m) ;
        }

        return Math.sqrt(ans / (trials  - 1));
    }

    /**
     * low endpoint of 95% confidence interval.
     */

    public double confidenceLo() {
        double m = mean();
        double s = stddev();

        return m - (CONFIDENCE_95 * s) / Math.sqrt(trials);
    }

    /**
     * high endpoint of 95% confidence interval.
     */

    public double confidenceHi() {
        double m = mean();
        double s = stddev();

        return m + (CONFIDENCE_95 * s) / Math.sqrt(trials);
    }

    /**
     * test client (see below).
     */

    public static void main(String[] args) {
        int a = StdIn.readInt();
        int b = StdIn.readInt();

        PercolationStats c = new PercolationStats(a, b);

        System.out.println("mean                    = " + c.mean());
        System.out.println("stddev                  = " + c.stddev());
        System.out.println("95% confidence interval = [" + c.confidenceLo() + ", " + c.confidenceHi() + "]");
    }
}
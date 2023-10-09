
import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }


    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }


    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }


    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        if(x == that.x) {
            if(y == that.y){
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
        if(y == that.y){
            return 0.0;
        }

        return  1.0 * (that.y - y) / (that.x - x);
    }


    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        if(y == that.y){
            return ((x == that.x) ? 0 : ((x > that.x) ? 1 : -1));
        }
        return ((y > that.y) ? 1 : -1);
    }



    private class SlopeOrder implements Comparator<Point> {
        @Override
        public int compare(Point a,Point b){
            double a1 = slopeTo(a) , b1 = slopeTo(b) ;
            if((a1 == b1)){
                return a.compareTo(b);
            }
            return Double.compare(a1, b1);
        }
    }
    public Comparator<Point> slopeOrder() {
        /* YOUR CODE HERE */
        return new SlopeOrder();
    }



    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        /* YOUR CODE HERE */
        Point [] a = new Point[7] ;

        a[0] = new Point(0, 0);
        a[1] = new Point(0, 1);
        a[2] = new Point(0, 2);
        a[3] = new Point(1, 1);
        a[4] = new Point(2, 2);
        a[5] = new Point(0, 3);
        a[6] = new Point(3, 3);

     FastCollinearPoints aa = new FastCollinearPoints(a);
        LineSegment [] b = aa.segments();
        System.out.println(b.length);
        for(int i = 0;i < b.length;i ++){
            System.out.println("?? " + b[i].toString());
       //     b[i].draw();
        }
   /*
        Point [] b = a.clone();

        Arrays.sort(a, b[0].slopeOrder());

        int id1 = 1 , id2  ;

        while (id1 < a.length) {
            id2 = id1;

            while ((id2 < a.length) && ((b[0].slopeTo(a[id2]) == b[0].slopeTo(a[id1])))) {
                id2++;
            }

            System.out.println(id1  +  "  " + (id2 - 1));
            id1 = id2;
        }

        for(int i = 0;i < 7;i ++){
        //    System.out.println(b[i].x + " " + b[i].y);
            System.out.println(" ?? " + a[i].x + " " + a[i].y + " " + b[0].slopeTo(a[i]));
        }*/


    }
}
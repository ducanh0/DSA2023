import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> arr = new ArrayList<>();
    public BruteCollinearPoints(Point[] points)  {
        if(points == null){
            throw new IllegalArgumentException();
        }
        for(int i = 0;i < points.length;i ++) {
            if(points[i] == null){
                throw new IllegalArgumentException();
            }
            for(int j = 0;j < i;j ++){
                if(points[i].compareTo(points[j]) == 0){
                    throw new IllegalArgumentException();
                }
            }
        }

        for(int i = 0;i < points.length;i ++){
            for(int j = i + 1;j < points.length;j ++){
                for(int k = j + 1;k < points.length;k ++){
                    for(int t = k + 1;t < points.length;t ++){
                        if(thangHang(points[i], points[j], points[k], points[t])){
                            Point mn = new Point(0, 40000) , mx = new Point(0, -40000);

                            if(mn.compareTo(points[i]) > 0){
                                mn = points[i];
                            }
                            if(mx.compareTo(points[i]) < 0) {
                                mx = points[i];
                            }

                            if(mn.compareTo(points[j]) > 0){
                                mn = points[j];
                            }
                            if(mx.compareTo(points[j]) < 0) {
                                mx = points[j];
                            }

                            if(mn.compareTo(points[k]) > 0){
                                mn = points[k];
                            }
                            if(mx.compareTo(points[k]) < 0) {
                                mx = points[k];
                            }

                            if(mn.compareTo(points[t]) > 0){
                                mn = points[t];
                            }
                            if(mx.compareTo(points[t]) < 0) {
                                mx = points[t];
                            }

                            LineSegment ab = new LineSegment(mn, mx);

                            arr.add(ab);
                        }
                    }
                }
            }
        }
    }  // finds all line segments containing 4 points

    private boolean thangHang(Point a,Point b,Point c,Point d){
        double x1 = a.slopeTo(b) , x2 = a.slopeTo(c) , x3 = b.slopeTo(d);
        return ((x1 == x2) && (x2 == x3));
    }
    public           int numberOfSegments() {
        return arr.size();
    }       // the number of line segments
    public LineSegment[] segments()     {
            LineSegment [] ans = new LineSegment[numberOfSegments()];

            for(int i = 0;i < ans.length;i ++){
                ans[i] = arr.get(i);
            }

            return ans;
    }           // the line segments

    public static void main(String [] args){
        System.out.println("halo");
    }
}
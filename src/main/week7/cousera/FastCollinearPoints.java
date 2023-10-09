import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private ArrayList<LineSegment> arr = new ArrayList<>();
    public FastCollinearPoints(Point[] points)  {
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

        if(points.length >= 4){
            Point [] ar = points.clone() ;
            for(int i = 0;i < points.length;i ++){


                Arrays.sort(ar, points[i].slopeOrder());

                int id1 = 0 , id2  ;

                while (id1 < ar.length){
                    id2 = id1;

                    while ((id2 < ar.length) && ( (points[i].slopeTo(ar[id2]) == points[i].slopeTo(ar[id1])))){
                        id2 ++ ;
                    }

                    if(id2 - id1 > 2) {
                        Point mn = new Point(0, 40000) , mx = new Point(0, -40000);

                        if(mn.compareTo(points[i]) > 0){
                            mn = points[i];
                        }
                        if(mx.compareTo(points[i]) < 0) {
                            mx = points[i];
                        }

                        for(int j = id1;j < id2;j ++){
                            if(mn.compareTo(ar[j]) > 0){
                                mn = ar[j];
                            }
                            if(mx.compareTo(ar[j]) < 0) {
                                mx = ar[j];
                            }
                        }

                        id1 = id2;

                        LineSegment ab = new LineSegment(mn, mx);

                        arr.add(ab);
                    }
                }
            }
        }
    }   // finds all line segments containing 4 or more points
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

    }      // the line segments
}
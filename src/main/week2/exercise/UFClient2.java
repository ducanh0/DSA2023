import edu.princeton.cs.algs4.*;
public class UFClient2 {
    public static void main(String [] args){
        int N = StdIn.readInt();

        UF uf = new UF(N);

        int soVungLienThong = N , soDong = 0 ;

        while ((soVungLienThong > 1) && (! StdIn.isEmpty())){
            int p = StdIn.readInt() , q = StdIn.readInt();
            soDong ++ ;
            if(! uf.connected(p, q)){
                uf.union(p, q);
                soVungLienThong -- ;
            }
        }

        if(soVungLienThong != 1) StdOut.print("FAILED");
        else StdOut.print(soDong);

    }
}

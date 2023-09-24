
import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class Permutation {
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);

        RandomizedQueue<String> kltm = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()){
            kltm.enqueue(StdIn.readString());
        }

        while (k > 0){
            System.out.println(kltm.dequeue());
            k -- ;

        }
    }
}

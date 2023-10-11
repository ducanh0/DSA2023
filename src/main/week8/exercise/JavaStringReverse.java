
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        int i = 0 , j = A.length() - 1;
        boolean ok = true;

        while (i < j){
            ok &= (A.charAt(i) == A.charAt(j));

            i ++ ; j -- ;
        }

        System.out.println((ok) ? "Yes" : "No");
    }
}


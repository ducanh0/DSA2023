/**
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.Scanner;

 public class Main {


 public static void main(String [] args) {
 Scanner io = new Scanner(System.in);
 int n = io.nextInt();
 io.nextLine();
 HashSet<String> s = new HashSet<>();

 while (n -- > 0){
 //   io.nextLine();
 String ss = io.nextLine();

 if(! s.contains(ss)){
 s.add(ss);
 }

 System.out.println(s.size());
 }
 }
 }



 */
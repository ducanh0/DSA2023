
 import java.util.Comparator;
 import java.util.PriorityQueue;
 import java.util.Queue;
 import java.util.Scanner;

 public class Student {
 private double cgpa;
 private int id;
 private String name;
 public Student(int id, String name, double cgpa){
 this.id = id;
 this.name = name;
 this.cgpa = cgpa;
 }

 public int getId(){
 return id;
 }

 public double getCgpa(){
 return cgpa;
 }

 public String getName(){
 return name;
 }

 static class StudentOrder implements Comparator<Student> {
@Override
public int compare(Student a,Student b){
if(a.cgpa == b.cgpa){
if(a.name.compareTo(b.name) == 0){
return Integer.compare(b.id, a.id);
}
return a.name.compareTo(b.name);
}
return Double.compare(b.cgpa, a.cgpa);
}
}

 public static void main(String [] args){
 Queue<Student> pq = new PriorityQueue<>(new StudentOrder());

 Scanner io = new Scanner(System.in);
 int n = io.nextInt();
 while (n -- > 0){
 String s = io.next();

 switch (s){
 case "ENTER" :{
 String name = io.next();
 double cgpa = io.nextDouble();
 int id = io.nextInt();

 Student st = new Student(id, name, cgpa);

 pq.add(st);

 break;
 }
 default:{
 if(pq.size() == 0){
 ;
 } else{
 pq.poll();
 }
 }
 }
 }
 if(pq.size() == 0){
 System.out.println("EMPTY");
 } else {
 while (pq.size() > 0){
 System.out.println(pq.poll().getName());
 }
 }
 }
 }


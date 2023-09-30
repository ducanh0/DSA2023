
import java.io.*;
import java.util.*;

public class Solution {
    private static class Student {
        int id ;
        String name ;
        double cgpa;

        public  Student(int id, String name,double cgpa) {
            this.id = id ;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public void setId(int id){
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public void setCgpa(double cgpa){
            this.cgpa = cgpa;
        }

        public boolean compare(Student other) { /// is bigger , consider gpa , name , id ?
            if(cgpa > other.getCgpa()){
                return true;
            }
            if(cgpa < other.getCgpa()){
                return false;
            }
            if(name.compareTo(other.getName()) < 0){
                return true;
            }
            if(name.compareTo(other.getName()) > 0){
                return false;
            }
            return (id > other.getId());
        }

        public void swap(Student other){
            int temp = id ;
            setId(other.getId()); other.setId(temp);

            String temp1 = name;
            setName(other.getName()); other.setName(temp1);

            double temp2 = cgpa;
            setCgpa(other.getCgpa()); other.setCgpa(temp2);
        }
    }

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();

        Student [] arr = new Student[n] ;

        for(int i = 0;i < n;i ++){
            int id = io.nextInt() ;
            String name = io.next() ;
            double gpa = io.nextDouble();

            arr[i] =  new Student(id, name, gpa);
            //   arr[i].setCgpa(gpa); arr[i].setId(id); arr[i].setName(name);

            for(int j = i - 1;j >= -1 ;j --){
                if(j == -1) {
                    int idx = i ;
                    while (idx > 0){
                        arr[idx].swap(arr[idx - 1]);
                        idx -- ;
                    }

                    break;
                }
                if(arr[i].compare(arr[j])){
                    continue;
                }

                int idx = i ;
                while (idx > j + 1){
                    arr[idx].swap(arr[idx - 1]);
                    idx -- ;
                }

                break;
            }
        }

        for(int i = 0;i < n;i ++){
            System.out.println(arr[i].getName());
        }
    }
}

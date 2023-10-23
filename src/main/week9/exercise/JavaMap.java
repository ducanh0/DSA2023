/**
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    public static void main(String [] args) {
        Scanner io = new Scanner(System.in);

        int n = io.nextInt();



        HashMap<String, Integer> m = new HashMap<>();

        while (n -- > 0){
            io.nextLine();
            String name = io.nextLine();

            int number = io.nextInt();
            //    System.out.println(name + " " + number);

            m.put(name, number);
        }

        //  System.out.println("okay" + n);
        io.nextLine();
        while (io.hasNext()){
            // io.nextLine();
            String name = io.nextLine();

            if(m.containsKey(name)){
                System.out.println(name + "=" + m.get(name));
            } else {
                System.out.println("Not found");
            }
            // io.nextLine();
        }

    }
}


*/
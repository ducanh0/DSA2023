
 import java.io.*;
 import java.math.*;
 import java.security.*;
 import java.text.*;
 import java.util.*;
 import java.util.concurrent.*;
 import java.util.function.*;
 import java.util.regex.*;
 import java.util.stream.*;
 import static java.util.stream.Collectors.joining;
 import static java.util.stream.Collectors.toList;

 class Result {

 public static List<Double> runningMedian(List<Integer> a) {
 // Write your code here
 PriorityQueue<Integer> mn = new PriorityQueue<>() , mx = new PriorityQueue<>(new customOrder());

 mn.add(100001) ; mx.add(-1);

 List<Double> ans = new ArrayList<>();

 for(int i = 0;i < a.size();i ++){
 mx.add(a.get(i));

 while (mx.peek() > mn.peek()){
 mn.add(mx.poll());

 if(mn.size() > mx.size()){
 break;
 }
 }

 while (mn.peek() < mx.peek()){
 mx.add(mn.poll());

 if(mx.size() > mn.size()){
 break;
 }
 }

 while (mx.size() > mn.size() + 1){
 mn.add(mx.poll());
 }

 while (mn.size() > mx.size() + 1){
 mx.add(mn.poll());
 }

 if(mx.size() == mn.size()){
 ans.add(1.0 * (mx.peek() + mn.peek()) / 2);
 } else {
 if(mx.size() > mn.size()) {
 ans.add(1.0 * mx.peek());
 } else {
 ans.add(1.0 * mn.peek());
 }
 }
 }
 return ans;
 }

 static class customOrder implements Comparator<Integer> {
@Override
public int compare(Integer a, Integer b){
return Integer.compare(b, a);
}

}

 }

 public class Solution {
 public static void main(String[] args) throws IOException {
 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

 int aCount = Integer.parseInt(bufferedReader.readLine().trim());

 List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
 try {
 return bufferedReader.readLine().replaceAll("\\s+$", "");
 } catch (IOException ex) {
 throw new RuntimeException(ex);
 }
 })
 .map(String::trim)
 .map(Integer::parseInt)
 .collect(toList());

 List<Double> result = Result.runningMedian(a);

 bufferedWriter.write(
 result.stream()
 .map(Object::toString)
 .collect(joining("\n"))
 + "\n"
 );

 bufferedReader.close();
 bufferedWriter.close();
 }
 }


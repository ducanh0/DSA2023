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

public class Solution {
    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> ss = new Stack<Character>();

        for(int i = 0;i < s.length();i ++){
            if((s.charAt(i) == '(') || (s.charAt(i) == '[') || (s.charAt(i) == '{')){
                ss.push(s.charAt(i));
            } else {
                if(ss.empty()){
                    return "NO" ;
                } else {
                    if(((s.charAt(i) == ')') && (ss.peek() == '(')) ||
                            ((s.charAt(i) == ']') && (ss.peek() == '[')) ||
                            ((s.charAt(i) == '}') && (ss.peek() == '{'))){
                        ss.pop();
                    } else {
                        return "NO" ;
                    }
                }
            }
        }

        return (ss.empty() ? "YES" : "NO");
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.isBalanced("(([))"));
    }
}

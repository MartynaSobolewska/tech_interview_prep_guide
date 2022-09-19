package medium.reverseInParenthesis;

import javafx.util.Pair;

import java.util.*;

public class Main {

    static String solution4(String inputString) {
        StringBuilder solution = new StringBuilder(inputString);
        int start = inputString.lastIndexOf('(');
        int end = inputString.indexOf(')', start);
        while(start != -1){
            StringBuilder first = new StringBuilder(solution.substring(0, start));
            StringBuilder middle = new StringBuilder(solution.substring(start+1, end)).reverse();
            String last = solution.substring(end+1);
            solution = first.append(middle).append(last);

            start = solution.lastIndexOf("(");
            end = solution.indexOf(")", start);
        }
        return solution.toString();
    }

    public static void main(String[] args) {
//        String s = "foo(bar(baz))blim";
        String s = "(skeeg(for)skeeg())";
        // foobaz
        System.out.println("For string: " + s);
        System.out.println("Output: " + solution4(s));
    }
}

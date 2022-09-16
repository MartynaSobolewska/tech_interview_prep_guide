package easy.allLongestStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String[] solution(String[] inputArray) {
        int max = 0;
        List<String> longest = new ArrayList<>();
        for(String s : inputArray){
            int len = s.length();
            if(len > max){
                max = len;
                longest.clear();
                longest.add(s);
            }else if(len == max){
                longest.add(s);
            }
        }
        return longest.toArray(new String[0]);
    }

    // https://app.codesignal.com/arcade/intro/level-3/fzsCQGYbxaEcTr2bL/solutions?solutionId=XSJzHycgHNwLgZcmS
    static String[] solution2(String[] inputArray) {

        String l = ""; //full string with "-" separator

        for( String s: inputArray )
        {
            //length is first index of substring
            //if list has same size strings, add this one
            if( l.indexOf("-") == s.length() ) l += s + "-";
                //reset if list has smaller strings
            else if ( l.indexOf("-") < s.length() ) l = s + "-";
        }

        return l.split( "-" );
    }

    public static void main(String[] argc){
        String[] str = {"a", "aba", "abc", "aaaa", "bbbb", "c"};
        str = solution(str);
        System.out.print("[");
        for (String s :
                str) {
            System.out.print(s + " ");
        }
        System.out.println("]");
    }
}

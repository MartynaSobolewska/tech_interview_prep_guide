package medium.palindromeRearranging;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    static boolean solution(String inputString) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            char curr = inputString.charAt(i);
            if (map.containsKey(curr))
                map.put(curr, map.get(curr) + 1);
            else
                map.put(curr, 1);
        }
        int oddNumbers = 0;
        for (Integer i : map.values()) {
            if (i % 2 != 0) {
                oddNumbers++;
                if (oddNumbers > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean solution2(String inputString) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (set.contains(inputString.charAt(i))){
                set.remove(inputString.charAt(i));
            }else
                set.add(inputString.charAt(i));
        }
        if(set.size() > 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "abbbbbbbbbako";
        System.out.println("String \"" + s + "\" can be arranged into a palindrome: " + solution2(s));
    }
}

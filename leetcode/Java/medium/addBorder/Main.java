package medium.addBorder;

import java.util.Arrays;

public class Main {
    static String[] solution(String[] picture) {
        String[] solution = new String[picture.length + 2];
        String border = "*".repeat(picture[0].length()+2);
        solution[0] = border;
        solution[solution.length-1] = border;
        for (int i = 0; i < picture.length; i++) {
            solution[i+1] = "*" + picture[i] + "*";
        }
        return solution;
    }
    public static void main(String[] args){
        String[] s = {"ab","cd"};
        System.out.println("For: " + Arrays.toString(s));
        System.out.println("output: " + Arrays.toString(solution(s)));
    }
}

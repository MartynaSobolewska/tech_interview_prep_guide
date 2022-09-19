package medium.alternatingSums;

import java.util.Arrays;

public class Main {
    static int[] solution(int[] a) {
        int[] solution = new int[2];
        for (int i = 0; i < a.length; i++){
            // i&1 or i%2 would work
            solution[i&1] += a[i];
        }
        return solution;
    }

    public static void main(String[] args){
        int[] a = {50, 60, 60, 45, 70};
        System.out.println("For array: " + Arrays.toString(a));
        System.out.println("output: " + Arrays.toString(solution(a)));
    }
}

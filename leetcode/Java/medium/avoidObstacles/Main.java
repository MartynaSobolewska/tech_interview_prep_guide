package medium.avoidObstacles;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int solution(int[] inputArray) {
        int solution = 2;
        HashSet<Integer> allDivisors = new HashSet<>(inputArray.length);
        for (int i = 0; i < inputArray.length; i++) {
            for(int j = inputArray[i]; j > 1; j--){
                if(inputArray[i] % j == 0 && !allDivisors.contains(j)){
                    allDivisors.add(j);
                    while(allDivisors.contains(solution)){
                        solution++;
                    }
                }
            }
        }

        return solution;
    }

    public static void main(String[] args){
        int[] a = {5, 3, 6, 7, 9};
        System.out.println("solution for: " + Arrays.toString(a) + ": " +solution(a));
    }
}

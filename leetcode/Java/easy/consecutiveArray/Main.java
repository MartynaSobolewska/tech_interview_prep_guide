package easy.consecutiveArray;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static int solution(int[] statues) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Map<Integer, Boolean> map = new HashMap<>();
        for (int statue : statues) {
            map.put(statue, false);
            if (statue < min){
                min = statue;
            }
            if (statue > max){
                max = statue;
            }
        }
        for (int i = min; i < max; i++) {
            if (!map.containsKey(i+1)){
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] x = {1, 2, 8, 9};
        System.out.println(solution(x));
    }
}

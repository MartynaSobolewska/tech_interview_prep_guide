package easy.adjacentProduct;

public class Main {
    static int solution(int[] inputArray) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length - 1; i++) {
            int prod = inputArray[i]*inputArray[i+1];
            if (prod > max){
                max = prod;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] x = {1, -10, -9, 100, 8, -9};
        System.out.println(solution(x));
    }
}

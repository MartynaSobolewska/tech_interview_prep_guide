package easy.matrixElementsSum;

import java.util.Arrays;

public class Main {
    static int solution(int[][] matrix) {
        int price = 0;
        int[] hauntedFloors = new int[matrix[0].length];
        Arrays.fill(hauntedFloors, matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i < hauntedFloors[j]){
                    System.out.println("matrix[" + i + "][" + j + "] = " + matrix[i][j]);
                    if (matrix[i][j] == 0){
                        hauntedFloors[j] = i;
                    }
                    price += matrix[i][j];
                }
            }
        }
        return price;
    }
    public static void main(String[] argc){
        int[][] matrix =
                {{1,1,1,0},
                {0,5,0,1},
                {2,1,3,10}};
        System.out.println(solution(matrix));
    }
}

package easy.matrixElementsSum;

import java.util.Arrays;

public class Main {
    static int solution(int[][] matrix) {
        int price = 0;
        for (int column = 0; column < matrix[0].length; column++){
            for (int row = 0; row < matrix.length; row++){
                if(matrix[row][column] == 0)
                    break;
                price += matrix[row][column];
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

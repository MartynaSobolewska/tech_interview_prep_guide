package easy.shapeArea;

public class Main {
    static int solution(int n) {
        int middle = n*2 - 1;
        return (int)((middle*middle)/2)+1;
    }
    public static void main(String[] args) {
        System.out.println(solution(6));
    }
}

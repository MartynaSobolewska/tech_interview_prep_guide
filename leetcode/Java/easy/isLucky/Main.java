package easy.isLucky;

public class Main {
    static boolean solution(int n) {
        // number of digits in a number
        int len = (int)(Math.log10(n) + 1);
        int firstHalf = 0;
        int secondHalf = 0;

        for(int i = 0; i <= len/2; i++)
            secondHalf += (int)((n % Math.pow(10, i))/Math.pow(10, i-1));
        for(int i = len/2 + 1; i <= len; i++)
            firstHalf += (int)((n % Math.pow(10, i))/Math.pow(10, i-1));

        return secondHalf == firstHalf;
    }
    public static void main (String[] args){
        System.out.println("1203 is lucky? : " + solution(1203));
    }
}

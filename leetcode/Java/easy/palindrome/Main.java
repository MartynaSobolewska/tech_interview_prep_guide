package easy.palindrome;

public class Main {
    static boolean solution(String inputString) {
        int corrIndex = inputString.length();
        for (int currIndex = 0; currIndex < corrIndex; currIndex++){
            corrIndex--;
            if (inputString.charAt(currIndex) != inputString.charAt(corrIndex)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("aacbcaa"));
    }
}

package easy.commonCharacterCount;

public class Main {

    static int solution(String s1, String s2) {
        char[] letters = new char[26];
        char[] letters2 = new char[26];
        int common = 0;
        // assuming char 97-122
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 97;
            letters[index] ++;
        }
        for(int i=0; i < s2.length(); i++){
            int index = s2.charAt(i) - 97;
            letters2[index] ++;
            if(letters[index] != 0 && letters[index] >= letters2[index])
                common++;
        }
        return common;
    }

    public static void main(String[] args){
        String s1 = "aaabccd";
        String s2 = "aabcccdd";
        System.out.println("word \"" + s1 +"\" and \"" + s2 + "\" have "+ solution(s1, s2) + " characters in common.");
    }
}

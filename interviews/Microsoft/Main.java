import java.util.HashSet;

public class Main {
    public static int solution(String S) {
        HashSet<Character> hs = new HashSet<>();
        int pieces = 1;
        for (int i = 0; i < S.length(); i++) {
            if (!hs.contains(S.charAt(i)))
                hs.add(S.charAt(i));
            else{
                pieces++;
                hs.clear();
                hs.add(S.charAt(i));
            }
        }
        return pieces;
    }

    public static int solution2(int[] blocks) {
        int maxDistance = 0;
        int currDistance, left, right;
        for (int i = 0; i < blocks.length; i++) {
            boolean canExpandl = true;
            boolean canExpandr = true;
            left = i;
            right = i;
            while (canExpandl || canExpandr){
                if(left-1 > 0 && blocks[left-1] >= blocks[left])
                    left--;
                else
                    canExpandl = false;

                if(right+1 < blocks.length && blocks[right+1] >= blocks[right])
                    right++;
                else
                    canExpandr = false;

                currDistance = left != right ? right - left + 1 : 0;

                if (currDistance > maxDistance)
                    maxDistance = currDistance;
            }
        }
        return maxDistance;
    }

    public static void main(String[] args){
        String s = "dddddd";
        System.out.println(solution(s));

        int[] i = {1,1};
        System.out.println(solution2(i));
    }
}

package easy.almostIncreasingSequence;

public class Main {
    static boolean solution(int[] sequence) {
        if (sequence.length == 0){
            return false;
        }

        int prev = sequence[0];
        boolean remove = false;
        for (int i = 1; i < sequence.length; i++) {
            if (prev >= sequence[i]){
                if (remove){
                    return false;
                }
                // remove prev element
                if (i < 2 && (i+1 == sequence.length || sequence[i+1] > sequence[i])
                        || (i >= 2 && sequence[i-2] < sequence[i])){
                    remove = true;
                    prev = sequence[i];
                }
                // remove curr element
                else if((i+1) == sequence.length || sequence[i-1] < sequence[i+1]){
                    remove = true;
                    prev = sequence[i-1];
                }else{
                    return false;
                }
            }else
                prev = sequence[i];
        }
        return true;
    }
    public static void main(String[] args){
        int[] sequence = {1, 3, 2, 1};
        System.out.println(solution(sequence));
    }
}

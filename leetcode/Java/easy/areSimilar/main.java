package easy.areSimilar;

import java.util.Arrays;

public class main {
    static boolean solution(int[] a, int[] b) {
        int[] equivalenta = new int[2];
        int[] equivalentb = new int[2];

        int notMatchingCount = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i]!=b[i]){
                notMatchingCount++;
                if(notMatchingCount>2)
                    return false;

                equivalenta[notMatchingCount-1] = a[i];
                equivalentb[notMatchingCount-1] = b[i];
            }
        }

        if(notMatchingCount == 2){
            if(equivalenta[0] == equivalentb[1] && equivalenta[1] == equivalentb[0]){
                return true;
            }
        }if(notMatchingCount == 0)
            return true;

        return false;
    }

    public static void main(String[] args){
        int[] a = {1, 2, 2};
        int[] b = {2, 1, 3};
        System.out.println("Array " + Arrays.toString(a) + " and " + Arrays.toString(b) + " are similar?");
        System.out.println("Output: " + solution(a,b));
    }
}

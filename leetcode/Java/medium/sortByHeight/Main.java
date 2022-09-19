package medium.sortByHeight;

import sorts.quick_sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] solution(int[] a) {
        List<Integer> cheat = new ArrayList<>();
        List<Integer> nontrees = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if(a[i] != -1){
                cheat.add(a[i]);
                nontrees.add(i);
            }
        }
        Collections.sort(cheat);
        for (int i = 0; i < nontrees.size(); i++) {
            a[nontrees.get(i)] = cheat.get(i);
        }
        return a;
    }

    static int[] nonCheatingSolution(int[] a){
        List<Integer> cheat = new ArrayList<>();
        List<Integer> nontrees = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if(a[i] != -1){
                cheat.add(a[i]);
                nontrees.add(i);
            }
        }
//        Collections.sort(cheat);
        int[] sorted = QuickSort.quickSort(cheat.stream().mapToInt(i->i).toArray());
        for (int i = 0; i < nontrees.size(); i++) {
            a[nontrees.get(i)] = sorted[i];
        }
        return a;
    }

    static int[] nonCheatingSlowSolution(int[] a){
        for (int i = 0; i < a.length; i++){
            if (a[i] == -1)
                continue;
            for (int j = 0; j < a.length; j++) {
                while (a[j] == -1){
                    j++;
                }
                if (a[i] > a[j]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        return a;
    }
    public static void main(String[] args){
        int[] trees = {4, 22, 5, -1, -1, 1, 8, -1, 0};
        System.out.println("non-sorted trees:");
        System.out.println(Arrays.toString(trees));
        System.out.println("\nsorted trees:");
        trees = nonCheatingSlowSolution(trees);
        System.out.println(Arrays.toString(trees));
    }
}

package easy.addBorder;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {
    static String[] solution(String[] picture) {
        String[] solution = new String[picture.length + 2];
        String border = "*".repeat(picture[0].length()+2);
        solution[0] = border;
        solution[solution.length-1] = border;
        for (int i = 0; i < picture.length; i++) {
            solution[i+1] = "*" + picture[i] + "*";
        }
        return solution;
    }
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        System.out.println("head: "+pq.peek());
        Iterator itr=pq.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("queue poll: " + pq.poll());
        Iterator itr2 = pq.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }
//        String[] s = {"ab","cd"};
//        System.out.println("For: " + Arrays.toString(s));
//        System.out.println("output: " + Arrays.toString(solution(s)));
    }
}

package medium.connectedComponentsCount;

import java.util.*;

public class Main {
    public static int connectedComponentsCount(HashMap<Character, List<Character>> graph){
        if (graph.isEmpty())
            return 0;

        Set<Character> notVisited = new HashSet<>();
        notVisited.addAll(graph.keySet());
        int count = 0;

        while (!notVisited.isEmpty()){
            char curr = notVisited.toArray(new Character[graph.size()])[0];
            Queue<Character> queue = new LinkedList<>();
            queue.offer(curr);
            while (!queue.isEmpty()){
                curr = queue.poll();
                // now visited
                notVisited.remove(curr);
                System.out.println(curr + ": " + Arrays.toString(graph.get(curr).toArray()));
                for (Character c :
                        graph.get(curr)) {
                    if (notVisited.contains(c)) {
                        queue.offer(c);
                    }
                }
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args){
        // must not have directions
        HashMap<Character, List<Character>> graphWithCycles = new HashMap<>();
        List<Character> i2 = new ArrayList<>();
        i2.add('j');
        i2.add('k');
        graphWithCycles.put('i', i2);
        List<Character> j2 = new ArrayList<>();
        j2.add('i');
        j2.add('k');
        graphWithCycles.put('j', j2);
        List<Character> k2 = new ArrayList<>();
        k2.add('i');
        k2.add('j');
        k2.add('l');
        graphWithCycles.put('k', k2);
        List<Character> l2 = new ArrayList<>();
        l2.add('k');
        graphWithCycles.put('l', l2);
        // disconnected o
        graphWithCycles.put('o', new ArrayList<>());
        // disconnected b-a
        List<Character> a = new ArrayList<>();
        a.add('b');
        graphWithCycles.put('a', a);
        List<Character> b = new ArrayList<>();
        a.add('a');
        graphWithCycles.put('b', b);

        System.out.println(connectedComponentsCount(graphWithCycles));
    }
}

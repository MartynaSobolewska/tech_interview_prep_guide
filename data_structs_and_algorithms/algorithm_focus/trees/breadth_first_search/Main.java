package trees.breadth_first_search;
import data_structs_implementations.graph.Graph;

import java.sql.Array;
import java.util.*;


class Main {
    public static void main(String args[]) {
//        // create a tree for testing
//        Graph<String> graph = new Graph<>();
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//        graph.addVertex("F");
//        graph.addVertex("G");
//
//        graph.addEdge("A", "B", false);
//        graph.addEdge("A", "C", true);
//        graph.addEdge("B", "C", false);
//        graph.addEdge("C", "D", false);
//        graph.addEdge("D", "D", true);
//        graph.addEdge("D", "E", false);
//        graph.addEdge("A", "F", false);
//        graph.addEdge("A", "G", false);
//
//        // see the graph
//        System.out.println(graph);
//        // bfs - see in graph class
//        graph.bfs("B");


        // no class
        HashMap<Character, List<Character>> graph = new HashMap<>();
        List<Character> a = new ArrayList<>();
        a.add('b');
        a.add('c');
        graph.put('a', a);
        List<Character> c = new ArrayList<>();
        c.add('e');
        graph.put('c', c);
        List<Character> b = new ArrayList<>();
        b.add('d');
        graph.put('b', b);
        List<Character> d = new ArrayList<>();
        d.add('f');
        graph.put('d', d);
        graph.put('f', new ArrayList<>());
        graph.put('e', new ArrayList<>());

        Queue<Character> queue = new LinkedList<>();
        queue.add('a');

        while (!queue.isEmpty()){
            char curr = queue.remove();
            for (Character ch :
                    graph.get(curr)) {
                queue.add(ch);
            }
            System.out.println(curr);
        }

    }
}
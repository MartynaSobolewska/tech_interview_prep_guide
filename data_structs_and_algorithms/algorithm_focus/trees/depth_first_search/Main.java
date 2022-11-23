package trees.depth_first_search;

import data_structs_implementations.graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String args[]){
//        // create a graph for testing
//        Graph<String> graph = new Graph<>();
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//        graph.addVertex("F");
//        graph.addVertex("G");
//
//        graph.addEdge("B", "C", false);
//        graph.addEdge("B", "A", false);
//        graph.addEdge("C", "D", false);
//        graph.addEdge("D", "E", false);
//        graph.addEdge("A", "F", false);
//        graph.addEdge("A", "G", false);
//
//        // see the graph
//        System.out.println(graph);
//
//        // bfs - see in graph class
//        graph.dfsPostOrder("B");
//
//        // bfs - see in graph class
//        graph.dfsPreOrder("B");

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

        Stack<Character> stack = new Stack<>();
        // beginning with a
        stack.push('a');

        while (!stack.empty()){
            char curr = stack.pop();
            for (Character ch :
                    graph.get(curr)) {
                stack.push(ch);
            }
            System.out.println(" " + curr);
        }
    }
}

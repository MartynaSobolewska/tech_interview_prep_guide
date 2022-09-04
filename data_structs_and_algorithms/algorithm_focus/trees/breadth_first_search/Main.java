package trees.breadth_first_search;
import data_structs_implementations.graph.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String args[]) {
        // create a graph for testing
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", false);
        graph.addEdge("A", "C", true);
        graph.addEdge("B", "C", false);
        graph.addEdge("C", "D", false);
        graph.addEdge("D", "D", true);
        graph.addEdge("D", "E", false);
        graph.addEdge("A", "F", false);
        graph.addEdge("A", "G", false);

        // see the graph
        System.out.println(graph);
        // bfs - see in graph class
        graph.bfs("B");
    }
}
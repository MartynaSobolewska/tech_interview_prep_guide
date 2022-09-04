package trees.depth_first_search;

import data_structs_implementations.graph.Graph;

public class Main {
    public static void main(String args[]){
        // create a graph for testing
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("B", "C", false);
        graph.addEdge("B", "A", false);
        graph.addEdge("C", "D", false);
        graph.addEdge("D", "E", false);
        graph.addEdge("A", "F", false);
        graph.addEdge("A", "G", false);

        // see the graph
        System.out.println(graph);

        // bfs - see in graph class
        graph.dfsPostOrder("B");

        // bfs - see in graph class
        graph.dfsPreOrder("B");
    }
}

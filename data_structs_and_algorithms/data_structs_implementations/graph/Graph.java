package data_structs_implementations.graph;

// Java program to implement Graph
// with the help of Generics

import java.util.*;

public class Graph<T> {

    // We use Hashmap to store the edges in the graph
    private Map<T, List<T> > map = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(T s)
    {
        map.put(s, new LinkedList<T>());
    }

    public List<T> getEdgesAt(T key){
        if (map.containsKey(key)){
            return map.get(key);
        }else {
            return null;
        }
    }

    // This function adds the edge
    // between source to destination
    public void addEdge(T source,
                        T destination,
                        boolean bidirectional)
    {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

    // This function gives the count of vertices
    public int getVertexCount()
    {
        System.out.println("The graph has "
                + map.keySet().size()
                + " vertex");
        return map.keySet().size();
    }

    // This function gives the count of edges
    public void getEdgesCount(boolean bidirection)
    {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("The graph has "
                + count
                + " edges.");
    }

    // This function gives whether
    // a vertex is present or not.
    public void hasVertex(T s)
    {
        if (map.containsKey(s)) {
            System.out.println("The graph contains "
                    + s + " as a vertex.");
        }
        else {
            System.out.println("The graph does not contain "
                    + s + " as a vertex.");
        }
    }

    // This function gives whether an edge is present or not.
    public void hasEdge(T s, T d)
    {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between "
                    + s + " and " + d + ".");
        }
        else {
            System.out.println("The graph has no edge between "
                    + s + " and " + d + ".");
        }
    }

    public void bfs(T first){
        System.out.println("Breadth first search:");
        System.out.println(first);
        // holds all visited vertices
        Map<T, Boolean> visited = new HashMap<>();

        // Create a queue for BFS
        LinkedList<T> queue = new LinkedList<>();

        // visited the first node
        visited.put(first, true);

        // fill out the queue with children
        List<T> temp = this.getEdgesAt(first);
        for (T edge: temp) {
            queue.push(edge);
        }

        // keep track of which node is currently being processed
        T curr;

        while (!queue.isEmpty()){
            // get the node that has been in the queue the longest time out of the queue
            curr = queue.pop();
            // has it been visited?
            if (!visited.containsKey(curr)){
                // if not, fill out  the queue with children
                List<T> temp2 = this.getEdgesAt(curr);
                for (T edge: temp2) {
                    queue.add(edge);
                }
                // now it has been visited
                visited.put(curr, true);
                // print it
                System.out.println(curr);
            }
        }


    }

    // Prints the adjancency list of each vertex.
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }
}
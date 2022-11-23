package trees.has_path;

import java.util.*;

public class Main {
    public static boolean hasPathDepthFirst(HashMap<Character, List<Character>> graph, char start, char end){
        if (start == end)
            return true;

        Stack<Character> nodes = new Stack<>();
        Set<Character> visited = new HashSet<>();
        // first node
        nodes.push(start);

        while (!nodes.empty()){
            char curr = nodes.pop();
            visited.add(curr);
            if (curr == end)
                return true;

            if (!graph.containsKey(curr)){
                System.out.println("Badly formatted graph!");
                return false;
            }

            for (char c :
                    graph.get(curr)) {
                if (!visited.contains(c))
                    nodes.push(c);
            }
        }

        return false;
    }

    public static boolean hasPathBreadthFirst(HashMap<Character, List<Character>> graph, char start, char end){
        if (start == end)
            return true;

        Queue<Character> nodes = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        // first node
        nodes.offer(start);

        while (!nodes.isEmpty()){
            char curr = nodes.poll();
            visited.add(curr);
            if (curr == end)
                return true;

            if (!graph.containsKey(curr)){
                System.out.println("Badly formatted graph!");
                return false;
            }

            for (char c :
                    graph.get(curr)) {
                if (!visited.contains(c))
                    nodes.add(c);
            }
        }

        return false;
    }

    public static void main (String[] args){
        HashMap<Character, List<Character>> graph = new HashMap<>();
        List<Character> f = new ArrayList<>();
        f.add('g');
        f.add('i');
        graph.put('f', f);
        List<Character> g = new ArrayList<>();
        g.add('h');
        graph.put('g', g);
        List<Character> i = new ArrayList<>();
        i.add('g');
        i.add('k');
        graph.put('i', i);
        List<Character> j = new ArrayList<>();
        j.add('i');
        graph.put('j', j);
        graph.put('h', new ArrayList<>());
        graph.put('k', new ArrayList<>());

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

        System.out.println("Graph has a path from h to j: " + hasPathDepthFirst(graph, 'h', 'j'));
        System.out.println("Graph has a path from j to h: " + hasPathDepthFirst(graph, 'j', 'h'));
        System.out.println("Graph has a path from j to h on a graph with cycles: " + hasPathDepthFirst(graphWithCycles, 'j', 'k'));
        System.out.println("Graph has a path from h to j using breadth first search: " + hasPathBreadthFirst(graph, 'h', 'j'));
        System.out.println("Graph has a path from j to h using breadth first search: " + hasPathBreadthFirst(graph, 'j', 'h'));
        System.out.println("Graph has a path from j to o on a graph with cycles: " + hasPathBreadthFirst(graphWithCycles, 'j', 'o'));

    }
}

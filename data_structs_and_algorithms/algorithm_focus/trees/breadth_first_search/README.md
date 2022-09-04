# Breadth First Search
`trees` `search`

breadth first search is a tree searching algorithm. 
It starts at the tree root and explores all nodes at the present depth prior to moving on to the nodes at the 
next depth level. Extra memory, usually a queue, is needed to keep track of the child nodes that were encountered 
but not yet explored.

![Alt Text](https://upload.wikimedia.org/wikipedia/commons/4/46/Animated_BFS.gif)

### pseudocode
```
procedure BFS(G, root) is
       let Q be a queue
       label root as explored
       Q.enqueue(root)
       while Q is not empty do
           v := Q.dequeue()
           if v is the goal then
               return v
           for all edges from v to w in G.adjacentEdges(v) do
              if w is not labeled as explored then
                  label w as explored
                  Q.enqueue(w)
```

### links
1. [wikipedia](https://en.wikipedia.org/wiki/Breadth-first_search), always handy
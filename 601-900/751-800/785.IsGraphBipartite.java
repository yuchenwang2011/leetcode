785. Is Graph Bipartite?
Medium

Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes 
into two independent subsets A and B such that every edge 
in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge 
between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  
There are no self edges or parallel edges: graph[i] does not contain i, 
and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.

Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.

Note:
graph will have length in range [1, 100].
graph[i] will contain integers in range [0, graph.length - 1].
graph[i] will not contain i or duplicate values.
The graph is undirected: if any element j is in graph[i], then i will be in graph[j].

Accepted 52,419 Submissions 118,547

//DFS + BFS两种方法都要掌握
//大概就是思路就是每个点，要是你已经被染色了，滚。不然二话不说就把你染成1.然后彻底搜身
Answer:
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(colors[i] == 0 && !helper(graph, colors, 1, i)) return false;
        }
        return true;
    }
    
    public boolean helper(int[][] graph, int[] colors, int color, int idx){
        if(colors[idx] != 0) {
            return colors[idx] == color;
        }
        colors[idx] = color;
        for(int next : graph[idx]){
            if(!helper(graph, colors, -color, next)) return false;
        }
        return true;
    }
}


class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(colors[i] != 0) continue;
            colors[i] = 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            
            while(!queue.isEmpty()) {
                int node = queue.poll();
                for(int next : graph[node]){
                    if(colors[next] == 0) {
                        colors[next] = -colors[node];
                        queue.offer(next);
                    } else if (colors[next] != -colors[node]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

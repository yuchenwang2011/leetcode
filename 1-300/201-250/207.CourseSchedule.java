207. Course Schedule
Medium

There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
             
Example 2:
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
             
Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

Hint1:
This problem is equivalent to finding if a cycle exists in a directed graph. 
If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.

Hint2:
Topological Sort via DFS - A great video tutorial (21 minutes) https://www.coursera.org/specializations/algorithms
on Coursera explaining the basic concepts of Topological Sort.

Hint3:
Topological sort could also be done via BFS.

Answer:
//very good tutorial video what is topoligy sort https://www.youtube.com/watch?v=ddTC4Zovtbc
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //numCourses can be smaller than prerequisites
        if(numCourses < 0) return false;
        if(prerequisites == null || prerequisites.length == 0) return true;
        
        int[] indegree = new int[numCourses];
        int result = numCourses;
        for(int[] course: prerequisites){
            indegree[course[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            result--;
            for(int[] course : prerequisites){
                if(course[1] == num) {
                    indegree[course[0]]--;
                    //be careful! the if below should be inside of this if condition!
                    if(indegree[course[0]] == 0) {
                        queue.offer(course[0]);
                    }
                }
            }
        }
        
        return result == 0;
    }
}
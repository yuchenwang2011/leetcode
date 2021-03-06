286. Walls and Gates   My Submissions QuestionEditorial Solution
Total Accepted: 8662 Total Submissions: 23234 Difficulty: Medium
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 
to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. 
If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
  
Answer:
//我自己的答案 bfs 模板
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0) queue.offer(new int[]{i,j});
            }
        }
        
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] tmp = queue.poll();
                int a = tmp[0];
                int b = tmp[1];
                for(int[] direction : directions){
                    int x = a + direction[0];
                    int y = b + direction[1];
                    if(x >= 0 && y >= 0 && x < m && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                        queue.offer(new int[]{x, y});
                        rooms[x][y] = rooms[a][b] + 1;
                    }
                }
            }
        }
    }
}

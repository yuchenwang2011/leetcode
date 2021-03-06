63. Unique Paths II My Submissions Question
Total Accepted: 55959 Total Submissions: 194461 Difficulty: Medium
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.

Answer:
//my own solution
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        
        for(int i = 0; i < dp[0].length; i++){
            if(obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        
        for(int i = 0; i < dp.length; i++){
            if(obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}

//second optimized method
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       if(obstacleGrid == null) {
           return 0;
       }
       if(obstacleGrid[0][0] == 1){
           return 0;
       }
       int row = obstacleGrid.length; int column = obstacleGrid[0].length;
       if(row*column == 0) {return 0;}
       
       int[] dp = new int[column];
       dp[0] = 1;
       for(int i = 0; i < row; i++){
           for(int j = 0; j < column; j++){
               if(obstacleGrid[i][j]==1){
                   dp[j]=0;
               } else if (j > 0){  //here is a little tricky
                   dp[j] = dp[j] + dp[j-1];
               }
           }
       }
       return dp[column-1];
    }
}

118. Pascal's Triangle My Submissions Question
Total Accepted: 69921 Total Submissions: 218783 Difficulty: Easy
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
Answer:
public class Solution {
    //not quite understand, also need to know how to use ArrayList set();
    public List<List<Integer>> generate(int numRows) {
      //Got inspired by this https://leetcode.com/discuss/16178/solution-in-java
      List<List<Integer>> triangle = new ArrayList<List<Integer>>();
      numRows = Math.abs(numRows);
      if (numRows == 0) {
          return triangle;
      }
        for (int i=0; i<numRows; i++){
            List<Integer> row =  new ArrayList<Integer>();
            for (int j=0; j<i+1; j++){
                if (j==0 || j==i){
                    row.add(1);
                } else {
                    row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}

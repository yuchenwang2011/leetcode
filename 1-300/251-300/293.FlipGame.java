293. Flip Game My Submissions Question
Total Accepted: 7244 Total Submissions: 14726 Difficulty: Easy
You are playing the following Flip Game with your friend: 
Given a string that contains only these two characters: + and -, 
you and your friend take turns to flip two consecutive "++" into "--". 
The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].

Answer:
//2019/Aug/11：以后不许修改和增添任何答案，这个是我自己的答案
//注意，substring(i,start) start最低是0,这时候啥都没有
//如果substring(start), start最大是s.length()
//也就是说substring接受的最大范围就是0到s.length()
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() < 2) return result;
      
        int idx = 0;
        while(s.indexOf("++", idx) != -1){
            idx = s.indexOf("++", idx);
            String tmp = s.substring(0,idx) + "--" + s.substring(idx + 2);
            result.add(tmp);
            idx++;
        }
        
        return result;
    }
}

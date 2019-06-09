151. Reverse Words in a String My Submissions Question
Total Accepted: 95637 Total Submissions: 610939 Difficulty: Medium
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

Answer:
public class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+"," ");
        if(s == null || s.length() == 0) return s;
        String[] tmp = s.split("\\s");
        String result = "";
        for(int i = tmp.length-1; i >=1; i--) {
            result = result + tmp[i] + " ";
        }
        result += tmp[0];
        return result;
    }
}

283. Move Zeroes My Submissions Question
Total Accepted: 46182 Total Submissions: 107690 Difficulty: Easy
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order 
of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

Answer:
public class Solution {
    public void moveZeroes(int[] nums) {
        //https://leetcode.com/discuss/59073/java-o-n-solution-in-place-without-basecase, the answer
        //https://leetcode.com/discuss/59015/simple-o-n-java-solution-using-insert-index
        //*************I think two pointers questions, first to iterate i, then a if condition will increment another j
        if(nums.length == 0 || nums == null) {
            return;
        }
        int insertPosition = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPosition] = nums[i];
                insertPosition ++;
            }
        }
        int numOfZeros = nums.length - insertPosition;
        for(int i =0; i < numOfZeros; i++){
            nums[insertPosition+i] = 0;
        }
    }
}
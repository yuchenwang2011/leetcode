280. Wiggle Sort My Submissions Question
Total Accepted: 5998 Total Submissions: 12391 Difficulty: Medium
Given an unsorted array nums, reorder it in-place such that 
nums[0] <= nums[1] >= nums[2] <= nums[3]....
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

Answer:
public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        for(int i = 1; i < nums.length; i++){
            if(i % 2 == 1 && nums[i-1] > nums[i]) swap(nums, i - 1, i);
            if(i % 2 == 0 && nums[i-1] < nums[i]) swap(nums, i - 1, i);
        }
    }
    public void swap(int[] nums, int start, int end){
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}

88. Merge Sorted Array My Submissions Question
Total Accepted: 83268 Total Submissions: 281352 Difficulty: Easy
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) 
to hold additional elements from nums2. The number of elements initialized in nums1 
and nums2 are m and n respectively.

Answer: 
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums1.length != m + n || nums2 == null || nums2.length != n) return;
        m--;
        n--;
        while(m >= 0 && n >= 0){
            nums1[m + n + 1] = nums1[m] >= nums2[n] ? nums1[m] : nums2[n];
            if(nums1[m + n + 1] == nums1[m]) m--;
            else n--;
        }
        if(m >= 0) return;
        while(n >= 0){
            nums1[n] = nums2[n];
            n--;
        }
    }
}

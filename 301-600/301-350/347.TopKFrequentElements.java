347. Top K Frequent Elements
Medium

Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

Accepted 264,695 Submissions 462,003

Answer:
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> bucket[] = new ArrayList[nums.length + 1];
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(num);
        }
        for(int i = bucket.length - 1; i >= 0; i--){
            if(k <= 0) break;
            if(bucket[i] == null) continue;
            result.addAll(bucket[i]);
            k -= bucket[i].size();
        }
        
        return result;
    }
}


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) return result;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(k + 1, (a,b) -> a[0] - b[0]);
        for(int key : map.keySet()){
            pq.offer(new int[]{map.get(key), key});
            while(pq.size() > k) pq.poll();
        }
        
        for(int[] i : pq){
            result.add(0, i[1]);
        }
        
        return result;
    }
}

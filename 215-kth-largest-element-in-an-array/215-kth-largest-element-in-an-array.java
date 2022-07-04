class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        
        for (int num : nums) {
            pq.add(num);
            
            if (pq.size() > k) pq.poll();
        }
        
        return pq.poll();
    }
}
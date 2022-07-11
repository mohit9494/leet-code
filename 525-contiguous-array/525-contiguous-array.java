class Solution {
    public int findMaxLength(int[] nums) {
        
        int k = 0;
        int sum = 0;
        int maxi = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] == 0) sum--;
            else sum++;
            
            if (sum == k) {
                maxi = i + 1;
            } else {
                if (map.containsKey(sum - k)) {
                    maxi = Math.max(maxi, i - map.get(sum - k));
                }
            }
            
            map.putIfAbsent(sum, i);
        }
        
        return maxi;
    }
}
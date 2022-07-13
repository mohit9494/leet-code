class Solution {
    
    private int atMostK(int[] nums, int k){
        
        int ans = 0;
        if (k == 0) return ans;
        int i = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        while (j < nums.length) {
            
          int n = nums[j];
          map.put(n, map.getOrDefault(n,0) + 1);
            
          while (map.size() > k) {

              int fre = map.get(nums[i]);

              if (fre == 1) map.remove(nums[i]);
              else map.put(nums[i], fre - 1);

              i++;
          }
            
          // Now we are in bounds
          ans += j - i + 1;
          j++;

        }
               
      return ans;
        
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atMostK(nums, k) - atMostK(nums, k - 1);
        
    }
}
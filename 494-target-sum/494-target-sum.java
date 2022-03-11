class Solution {
    
    int total;
    
    public int calculate1(int[] nums, int target, int idx, int sum) {
        
        // reached end of array
        if(idx == nums.length) {
            
            if(sum == target) return 1;
           else return 0;
            
        } else {
            
          return calculate1(nums, target, idx + 1, sum + nums[idx]) + 
          calculate1(nums, target, idx + 1, sum - nums[idx]);
        }
    }
    
        
    public int calculate2(int[] nums, int target, int idx, int sum, int[][] t) {
        
    if(idx == nums.length) {
        if(sum == target) return 1;
        else return 0;
    } else {
        
        // check for values
        if(t[idx][total + sum] != Integer.MIN_VALUE) 
        {
            return t[idx][total + sum];
        }
        
        return t[idx][total + sum] = calculate2(nums, target, idx + 1, sum + nums[idx], t) + 
            calculate2(nums, target, idx + 1, sum - nums[idx], t);        
    } 
    
    }
    
    
    public int findTargetSumWays(int[] nums, int target) {
       
        total = Arrays.stream(nums).sum();
        
        int[][] t = new int[nums.length + 1][2 * total + 1];
        
        for(int[] k : t) Arrays.fill(k, Integer.MIN_VALUE);
        
        return calculate2(nums, target, 0, 0, t);
        // return calculate1(nums, target, 0, 0);
        
    }
}
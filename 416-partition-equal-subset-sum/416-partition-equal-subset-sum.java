class Solution {
    
    public boolean isSubsetSum(int[] nums, int n, int sum, Boolean[][] t) {
     
        if(sum == 0) return true;
        
        if(n == 0 && sum > 0) return false;
        
        if (t[n][sum] != null) {
            return t[n][sum];}
        
        if(nums[n-1] > sum) {
            return t[n][sum] = isSubsetSum(nums, n-1, sum, t);
        } else  {
            return t[n][sum] = isSubsetSum(nums, n-1, sum - nums[n-1], t) || isSubsetSum(nums, n-1, sum, t);
        }
        
        
    }
    
    public boolean canPartition(int[] nums) {
     
        // Equal sum subset -> Extension of Subset sum
        
        // If two partition with sum s - there then total sum of array = s + s
        
        // Find sum of entire array
        int totalSum = 0;
        
        for(int num : nums) {
            totalSum += num;
        }
        
        // Check if odd or evem
        
        if(totalSum % 2 != 0) return false;
        
        int sum = totalSum / 2;
        int n = nums.length;
        
        Boolean[][] t = new Boolean[n+1][sum+1];
        
        return isSubsetSum(nums, n, sum, t);
        
    }
}
class Solution {
    
    private boolean isSubsetSum(int[] nums, int sum, int n, Boolean[][] t){
        
        // If sum is 0 => all true
        if(sum == 0) return true;
        
        // If n == 0 ans sum > 0 then all false
        if (n == 0 && sum > 0) return false;
        
        if (t[n][sum] != null) return t[n][sum];
        
        if(nums[n-1] > sum) {
            return t[n][sum] = isSubsetSum(nums, sum, n-1, t);
        } else {
            return t[n][sum] = isSubsetSum(nums, sum - nums[n-1], n-1, t) || isSubsetSum(nums, sum, n-1, t);
        }      
    
    }
    
    private boolean isSubsetSum2(int[] nums, int sum, int n, Boolean[][] t){
      
       for(int i = 0; i < n+1; i++) t[i][0] = true;
        
       for (int j = 1; j < sum + 1; j++ ) t[0][j] = false;
        
        for (int i = 1 ; i < n+1 ; i++) {
            for(int j = 1; j < sum + 1; j++){
                
                if (nums[i - 1] > j) {
                    t[i][j] = t[i-1][j];
                } else  {
                    t[i][j] = t[i-1][j - nums[i-1]] || t[i-1][j];
                }
                
                
            }
        }
        
    return t[n][sum];
    }
    
    public boolean canPartition(int[] nums) {
        
        
        // take sum -> check if odd or even 
        int totalSum = 0;
        
        for(int num : nums){
            totalSum += num;
        }
        
        if (totalSum % 2 != 0) return false;
        
        int sum = totalSum/2;
        int n = nums.length;
        
        Boolean[][] t = new Boolean[n+1][sum+1];
        
        return isSubsetSum2(nums, sum, n, t);        
    
    }
}
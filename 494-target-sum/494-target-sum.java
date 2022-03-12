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
    
//     public int helper(int[] nums, int n, int sum) {
        
//         int[][] t = new int[n+1][sum+1];
        
//         // sum = 0
//         for(int i = 0; i < n+1 ; i++) t[i][0] = 1;
        
//         for(int j = 1; j < sum + 1; j++) t[0][j] = 0;
        
//         for(int i = 1; i < n+1; i++) {
//             for(int j = 1; j < sum + 1; j++){
                
//                 if(nums[i-1] > j) {
//                     t[i][j] = t[i-1][j];
                    
//                 }else {
//                     t[i][j] = t[i-1][j] + t[i-1][j - nums[i-1]];
//                 }
                
//             }
//         }
        
//         return t[n][sum];
//     }
    
    public int findTargetSumWays(int[] nums, int target) {
        
//         if(nums.length == 1) {
//             if (nums[0] == Math.abs(target)) return 1;
//             else return 0;
//         }

           total = Arrays.stream(nums).sum();
        
//         int sum = (total + target)/2;
            
//         return helper(nums, nums.length, sum);    
        
        int[][] t = new int[nums.length + 1][2 * total + 1];
        
        for(int[] k : t) Arrays.fill(k, Integer.MIN_VALUE);
        
        return calculate2(nums, target, 0, 0, t);
        // return calculate1(nums, target, 0, 0);
        
    }
}
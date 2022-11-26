class Solution {
    
    public int helper(int i, int j, int[] arr, int[][] dp) {        
        if (j < i) return 0; 
        if (dp[i][j] != -1) return dp[i][j];
        int maxi = (int) -1e9;        
        // we start the reverse op since the independent partitions is impossible in baloon burst
        // so we assume that what happns if only one baloon is left and move in reverse direnction
        // if only 1 baloon is left -> 1 * b * 1 => arr[i - 1]  * arr[b] * arr[j + 1] => i - 1 and  j + 1 baloons (out of range) 
        // are surely present since 
        // they will be burst next
        for (int k = i; k <= j; k++) {
            // partition at k
            int val = (arr[i -  1] * arr[k] * arr[j + 1]) + helper(i, k - 1, arr, dp) + helper(k + 1, j, arr, dp);
            maxi = Math.max(maxi, val);
        }
        
        return dp[i][j] = maxi;
    }
    
    public int maxCoins(int[] nums) {
     // we add 1 and 1 to the to end to avoid oob
     int[] arr = new int[nums.length + 2];
     int n = arr.length;
     arr[0] = 1;
     arr[n - 1] = 1;
     for (int i = 0; i<= nums.length - 1; i++) arr[i + 1] = nums[i];
     int[][] dp = new int[n - 1][n - 1];
     for (int[] a : dp) Arrays.fill(a, -1);
     return helper(1, n - 2, arr, dp);
    }
}
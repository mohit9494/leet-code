class Solution {
    
    public int getLargestBitonic(int[] arr) {
        
        int n = arr.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        // fill dp1
        for (int i = 0; i <= n - 1; i++) {
            for (int prev = i - 1; prev >= 0; prev--) {
                if (arr[i] > arr[prev]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[prev]);
                }
            }
        }
        // fill dp2
        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i + 1; prev <= n - 1; prev++) {
                if (arr[i] > arr[prev]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[prev]);
                }
            }
        }
        
        int maxi = 1;
        
        for (int k = 0; k <= dp1.length - 1; k++) {
            if (dp1[k] > 1 && dp2[k] > 1) {
               maxi = Math.max(dp1[k] + dp2[k] - 1, maxi);  
            }
        }
        
        return maxi;
    }
    
    public int minimumMountainRemovals(int[] nums) {
        return nums.length - getLargestBitonic(nums);
    }
}
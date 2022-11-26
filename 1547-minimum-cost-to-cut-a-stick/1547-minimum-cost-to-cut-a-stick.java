class Solution {
    
    public int helper(int i, int j, List<Integer> arr, int[][] dp) {
        
        // If they crossed
        if (j < i) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int min = (int) 1e9;
        for (int k = i; k <= j; k++) {
            // giving the cut at index k and partition the subproblem
            int val = arr.get(j + 1) - arr.get(i - 1) + helper(i, k - 1, arr, dp) + helper(k + 1, j, arr, dp);
            min = Math.min(min, val);
        }
        return dp[i][j] = min;
    }
    
    public int minCost(int n, int[] cuts) {
       
        // we need to sort the array to make the subproblems independent
        // we need to add the 0 and last value n in the array to preserve length
        
        List<Integer> arr = new ArrayList<>();
        
        for (int i : cuts) arr.add(i);
        arr.add(0);
        arr.add(n);
        // Imp
        Collections.sort(arr);
        
        int[][] dp = new int[cuts.length + 1][cuts.length + 1];
        for(int[] a : dp) Arrays.fill(a, -1); 
        return helper(1, arr.size() - 2, arr, dp);
    }
}
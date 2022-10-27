class Solution {
    
    public int helper(int[][] cost, int house, int past, int[][] dp) {
        
        if (house == cost.length) return 0;
        
        if (dp[house][past] != -1) return dp[house][past];
        
        // select min cost by excluding past and trying all
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 2; i++) {
           if (i == past) continue;
           int value = cost[house][i] + helper(cost, house + 1, i, dp);
           min = Math.min(min,value); 
        }
        return dp[house][past] = min;
    }
    
    public int minCost(int[][] costs) {
        
        // pass costs, house number and last selected
        // for first one it will be 3
        // only two param change - house and color
        int[][] dp = new int[costs.length + 1][4];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(costs, 0, 3, dp);
        
    }
}
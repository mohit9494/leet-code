class Solution {
    

    
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        
        int[] dp = new int[n + 1];
        
        int a = cost[0];
        int b = cost[1];
        int c = 0;
        
        for (int i = 2; i <= n - 1; i++) {
            c = cost[i] + Math.min(b, a);
            a = b;
            b = c;
        }
        
        return Math.min(a,b);
        
    }
}
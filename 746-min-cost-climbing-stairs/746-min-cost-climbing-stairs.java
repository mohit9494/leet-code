class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        
        // top of floor is beyond array
        // u only pay till step i then from i jump 1 or 2
        int n = cost.length;
        // int[] dp = new int[n + 1];
        
        // Initialize dp array
        int a = cost[0];
        int b = cost[1];
        
        // here we need to reach n
        // to get there we need to pay toll till either n - 1 or n - 2 :: from there we can jump 1 or 2 steps for free
        // and we will reach n
        //now get the mimimum to reach n - 1 or n-2;
        
        for (int i = 2; i < n; i++) {
            int c = cost[i] + Math.min(a, b);
            a = b;
            b = c;
        }
        
        // calculating the naswer for nth destination
        return Math.min(a, b);
        
    }
}
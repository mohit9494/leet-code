class Solution {
    
    public int minCost(int[][] costs) { 
        
        int n = costs.length;
        int m = costs[0].length;
        
        for (int i = n - 2; i >= 0; i--) {
           for (int j = 0; j < m; j++) {
             
               // calculate the min such that 
               // it will exclude the j which is previous color
               int min = Integer.MAX_VALUE;
               for (int k = 0; k < m; k++) {
                   if (k == j) continue;
                   min = Math.min(min, costs[i + 1][k]);
               }
               
               costs[i][j] = costs[i][j] + min;
           }    
        }
        
        // answer will be in the first row of costs
        return Arrays.stream(costs[0]).min().getAsInt();
    }
    
}
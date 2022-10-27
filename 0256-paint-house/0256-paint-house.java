class Solution {
    
    public int minCost(int[][] costs) { 
        
        int n = costs.length;
        int m = costs[0].length;
        
        int[] previous = costs[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            
           int[] current = costs[i].clone();
            
           for (int j = 0; j < m; j++) {

               // calculate the min such that 
               // it will exclude the j which is previous color
               int min = Integer.MAX_VALUE;
               for (int k = 0; k < m; k++) {
                   if (k == j) continue;
                   min = Math.min(min, previous[k]);
               }
               
               current[j] = current[j] + min;
           } 
            previous = current;
        }
        
        // answer will be in the first row of costs
        return Arrays.stream(previous).min().getAsInt();
    }
    
}
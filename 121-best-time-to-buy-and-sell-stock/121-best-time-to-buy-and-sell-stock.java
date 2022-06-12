class Solution {
    public int maxProfit(int[] prices) {
        
        // This is Max differece between two Values
        // Kadane's algo
        
        int maxi = 0;
        int sum = 0;
        
        for (int i = 0; i < prices.length - 1; i++) {
            
            sum += prices[i + 1] - prices[i];
            
            maxi = Math.max(maxi, sum);
            
            // If sum = -ve then its useless
            if(sum < 0) sum = 0;
            
        }
        
        return maxi;
    }
}
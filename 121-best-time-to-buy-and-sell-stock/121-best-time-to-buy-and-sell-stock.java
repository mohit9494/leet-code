class Solution {
    public int maxProfit(int[] prices) {
        
        int maxi = 0;
        
        if(prices.length <= 0) return maxi;
        
        int min = Integer.MAX_VALUE;
        int j = 0;
        
        while (j < prices.length) {

         if (prices[j] < min) min = prices[j];
            
        maxi = Math.max(maxi, prices[j] - min);
            
         j++;   
            
        }        
        
        return maxi;
    }
}
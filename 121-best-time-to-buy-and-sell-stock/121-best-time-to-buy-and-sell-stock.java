class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int minVal = Integer.MAX_VALUE;
        
        for (int i : prices) {
            
           minVal = Math.min(minVal, i);
            
           maxProfit = Math.max(maxProfit, i - minVal);           
            
        }
        
        return maxProfit;
    }
}
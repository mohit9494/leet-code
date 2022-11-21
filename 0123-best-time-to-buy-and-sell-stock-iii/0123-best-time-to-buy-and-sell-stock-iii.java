class Solution {
    
    public int maxProfit(int[] arr) {
        int cap = 2;
        int n = arr.length;
        int[][] after = new int[2][cap + 1];
        int[][] curr = new int[2][cap + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1 ; buy++) {
                for (int c = 1; c <= cap; c++) {
                    
                    int profit = 0;
                    if (buy == 1) {
                        profit = Math.max(-arr[i] + after[0][c], 0 + after[1][c]);
                    } else {
                        // once sell is complete 1 transaction is complete
                        profit = Math.max(arr[i] + after[1][c - 1], 0 + after[0][c]);
                    }        
                    curr[buy][c] = profit;               
                }
            }
            after = curr;
        }
        
        return curr[1][cap];
    }
}
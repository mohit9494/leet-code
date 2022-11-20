class Solution {
    public int maxProfit(int[] arr) {
       
        int n = arr.length;
        int p = 0;    
        if (n == 1) return p;
        
        int min = arr[0];
        
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] >= min) {
                p = Math.max(p, arr[i] - min);
            }
            min = Math.min(min, arr[i]);
        }
        
 
        return p;
    }
}
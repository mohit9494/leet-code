class Solution {
    public int maxProfit(int[] arr) {
        
        // using vally and peak algo
        // always get vally first - at v -> buy;
        // total profit = sum(p) - sum(v)
        int n = arr.length;
        int i = 0;
        int profit = 0;
        int v = arr[0];
        int p = arr[0];
        
        while (i < n - 1) {
            
            while (i < n - 1 && arr[i] >= arr[i + 1]) i++;
            v = arr[i];
            
            while (i < n - 1 && arr[i] <= arr[i + 1]) i++;
            p = arr[i];           
            
           profit += p - v ;
        }        

        return profit;
    }
}
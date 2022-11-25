class Solution {
    
    public int lengthOfLIS(int[] arr) {
        
       int n = arr.length;   
       int[] dp = new int[n];
        // for printing the longest common seq
       int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        int lastIndex = 0;
       for (int i = 0; i <= n - 1; i++) {
           for (int prev = i - 1; prev >= 0; prev--) {
               if (arr[i] > arr[prev] && 1 + dp[prev] > dp[i]) {
                   dp[i] = 1 + dp[prev];
                   hash[i] = prev;
               }
           }
           
           if (dp[i] > maxi) {
               maxi = dp[i];
               lastIndex = i;
           }
       }
        
       List<Integer> ans = new ArrayList<>(); 
       ans.add(0, arr[lastIndex]);
        
       while(lastIndex != hash[lastIndex]) {
           lastIndex = hash[lastIndex];
           ans.add(0, arr[lastIndex]);
       }
        
      System.out.println(ans);

    return maxi;
    }
}
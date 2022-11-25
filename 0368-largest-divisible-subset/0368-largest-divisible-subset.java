class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        
        // this is similar to Longest Increaing Subseq
        // we need to sort the array for divisibility
        Arrays.sort(arr);
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxi = 1;
        int lastIndex = 0;
        
        Arrays.fill(dp, 1);
        
        for (int i = 0; i <= n - 1; i++) {
              hash[i] = i;
            for (int prev = i - 1; prev >= 0; prev--) {
                if (arr[i] % arr[prev] == 0 && dp[i] < 1 + dp[prev]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if (maxi < dp[i]) {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        
        // prepare the ans by jumping through indexes - hash 
       List<Integer> ans = new ArrayList<>(); 
       ans.add(arr[lastIndex]);
        
       while(lastIndex != hash[lastIndex]) {
           lastIndex = hash[lastIndex];
           ans.add(arr[lastIndex]);           
       }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(hash));
        
        return ans;
    }
}
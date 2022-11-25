class Solution {
    
    public boolean compare (String s1, String s2) {    
        // String s1 must be bigger than s2 by 1 only
        // abcd bcd
        if (s1.length() != s2.length() + 1) return false;
        
        int i = 0, j = 0;
        while (i <= s1.length() - 1 && j <= s2.length() - 1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        // if they are matching j will also reach end;
        return j == s2.length();
    }
    
    
    public int longestStrChain(String[] words) {
       int n = words.length;
       int[] dp = new int[n];
       Arrays.fill(dp, 1);
       // sort the words array as per length
       Arrays.sort(words, (x, y) -> x.length() - y.length());
       int maxi = 1;
        
       for (int i = 0; i <= n - 1; i++) {
           for (int prev = i - 1; prev >= 0; prev--) {
               if (compare(words[i], words[prev]) && dp[i] < 1 + dp[prev]) {
                   dp[i] = 1 + dp[prev];
               }
           }
           maxi = Math.max(maxi, dp[i]);
       }
       return maxi;       
    }
}
class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
      
  // If text1 doesn't reference the largest string, swap them.
    if (text2.length() > text1.length()) {
      String temp = text1;
      text1 = text2;
      text2 = temp;
    }  
        
      int n = text1.length();
      int m = text2.length();
      int[] prev = new int[m + 1];
      // int[] curr = new int[m + 1];
      // Initialization  - when i ==0 || j == 0 return 0 (Index right shifting by 1);
      
      for (int i = 1; i <= n; i++) {
           int[] curr = new int[m + 1];
          for (int j = 1; j <= m; j++) {
             
              if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                  curr[j] = 1 + prev[j - 1];
              } else {
                  curr[j] = Math.max(prev[j], curr[j - 1]);
              }
          }
          prev = curr;
      }
        
      return prev[m];
    }
}
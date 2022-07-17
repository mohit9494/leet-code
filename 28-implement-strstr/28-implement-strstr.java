class Solution {
    
    public int[] buildLps(String s) {
        
        int[] lps = new int[s.length()];
        
        int j = 0;
        int i = 1;
        
        while (i < s.length()) {
            
          if (s.charAt(j) == s.charAt(i)) {
              j++;
              lps[i] = j;
              i++;
          }  else if (s.charAt(j) != s.charAt(i) && j > 0) {
              j = lps[j - 1];
          } else if (s.charAt(j) != s.charAt(i) && j == 0) {
              i++;
          } 
            
            
        } 
        
        return lps;
    }
    public int strStr(String haystack, String needle) {
        
       if (needle == null || needle.length() == 0) return 0;
        
      int n = haystack.length();
      int m = needle.length();
        
      if (n < m) return -1;
      
      // build lps -> Longest prefix also Suffix
      int[] lps = buildLps(needle);
        
      int i = 0;
      int j = 0;
      
      while (i < n) {
          
          if (haystack.charAt(i) == needle.charAt(j)) {
              i++;
              j++;
              if (j == m) return i - m;
          } else if (j > 0) {
              j = lps[j - 1];
          } else if (j == 0) {
              i++;
          }
  
      }
        
      return -1;
    }
}
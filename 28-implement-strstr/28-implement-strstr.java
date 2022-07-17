class Solution {
    public int strStr(String haystack, String needle) {
        
       if (needle == null || needle.length() == 0) return 0;
        
      int n = haystack.length();
      int m = needle.length();
        
      if (n < m) return -1;
        
      int i = 0;
      int j = 0;
      
      while (i <= n - m) {
          
          if (haystack.charAt(i) == needle.charAt(j)) {
              
          int k = i;
              
          while (haystack.charAt(k) == needle.charAt(j)) {
              k++;
              j++;
              
              if (j == m) return i;
          }
              
          }
          
          i++;
          j= 0;
  
      }
        
        
      return -1;
    }
}
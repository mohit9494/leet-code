class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        // This is a bit different
        // There are 256 ASCII Chars
        int[] count = new int[256];
        
        int i = 0;
        int j = 0;
        int maxi = Integer.MIN_VALUE;
        int num = 0;
        
        while (j < s.length()) {
            
            // Added Char for the first time
            if (count[s.charAt(j)]++ == 0) {
               
                num++;
            }
                        
            while (num > k && i < s.length()) {
                
            count[s.charAt(i)]--;
                
            if (count[s.charAt(i)] == 0){ 
                num--;
            }
                
            i++; 
            
            }
            
            maxi = Math.max(maxi, j - i + 1);
            j++;
        }
        
        return maxi;
    }
}
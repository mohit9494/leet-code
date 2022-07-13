class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        int k = 2;
        
        if (s.length() <= k) return s.length();
        
        Map<Character, Integer> map = new HashMap<>();
        
        int ans = 0;
        
        int i = 0;
        int j = 0;
        
        while (j < s.length()) {
            
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            
            if (map.size() <= k) {
                
            ans = Math.max(ans, j - i + 1);
            j++;
                
            } else {
                
                // we crossed k
                while (map.size() > k) {
                    
                    // slide the window
                    char d = s.charAt(i);
                    
                    int fre = map.get(d);
                    
                    if (fre == 1) map.remove(d);
                    else map.put(d, map.get(d) - 1);
                    
                    i++;
                    
                }
             
                // at this point map.size() is again k
                j++;
                
            }
            
            
        }
        
        return ans;
        
    }
}
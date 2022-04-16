class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        // This is a classis window problen
        // Variable window with at most k
        
        if( k == 0 ) return 0;
        
        int i = 0;
        int j = 0;
        int maxi = 0;
        
        Map<Character, Integer> map = new HashMap();
        
        while (j < s.length()) {
            
            char c = s.charAt(j);            
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while(map.size() > k) {
                    
                    // slide the window till map.size() <= k
                    char d = s.charAt(i);
                    int fre = map.get(d);
                    
                    if(fre == 1) {
                        map.remove(d);
                    } else {
                        map.put(d , fre - 1);
                    }
                    
                    i++;
                }
                
            
            maxi = Math.max(maxi, j - i + 1);
            j++;
                
            }
        
        return maxi;
    }
}
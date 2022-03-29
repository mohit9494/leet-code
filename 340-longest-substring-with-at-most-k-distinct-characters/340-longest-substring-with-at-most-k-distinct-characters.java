class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    
        if(s == null || s.length() == 0 || k == 0 ) return 0;
        
        int i = 0;
        int j = 0;
        int maxi = 0 ;
        
        Map<Character, Integer> map = new HashMap<>();
        
        while(j < s.length()) {
            
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c , 0) + 1);
            
            while (map.size() > k ) {
                
                char d = s.charAt(i);
                
                int frequency = map.get(d);
                
                if(frequency == 1) {
                    map.remove(d);
                } else {
                    map.put(d, frequency - 1);
                }
                
                i++;
            }
            
            // At this point map.size() <= k count the maxi
            maxi = Math.max(maxi, j - i + 1);
            
            j++;
        }
        
        return maxi;
    }
}
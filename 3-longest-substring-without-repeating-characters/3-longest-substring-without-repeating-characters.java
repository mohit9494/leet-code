class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0) return 0;
        
        // Longest SubString without repeating Character
        int i = 0;
        int j = 0;
        int maxi = 0;
        
        Map<Character, Integer> map = new HashMap();
        
        while(j < s.length()) {
            
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c,0) + 1);
            
            if(map.size() == j - i + 1) {
                maxi = Math.max(maxi, j - i + 1);
                j++;
            } else {
                
                while (map.size() < j - i + 1) {
                    
                    char d = s.charAt(i);
                    
                    int frequency = map.get(d);
                    
                    if(frequency == 1) {
                        map.remove(d);
                    } else {
                        map.put(d, frequency - 1);
                    }
                    
                    i++;
                }
                
                j++;
                
            }
        }
        
        return maxi;
    }
}
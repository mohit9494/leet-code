class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList();
        
        if(p.length() > s.length()) return result;
        
        // Fill the map with p
        Map<Character, Integer> pMap = new HashMap();
        
        for(char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c,0) + 1);
        }
        
        
        int i = 0, j = 0;
        Map<Character, Integer> sMap = new HashMap();
        
        while(j < s.length()) {
            
            // process with J
            char c = s.charAt(j);
            if(sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) + 1);
            } else {
                sMap.put(c,1);
            }
            
            if (j -i +1 < p.length()) {
                j++;
            } else if (j - i + 1 == p.length()) {
                
                //calculate
                if(pMap.equals(sMap)) result.add(i);
                
                // slide the window -> remove ith char
                char ch = s.charAt(i);
                
                   if (sMap.get(ch) == 1) {
                    sMap.remove(ch);
                   }
        else {
          sMap.put(ch, sMap.get(ch) - 1);
        }
                
                i++;
                j++;
            }
 
        }
        
        return result;
    }
}
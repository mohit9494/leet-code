// Time complexity = O(N)
// space Complexity = O(N)

class Solution {
    public String minWindow(String s, String t) {
        
    HashMap<Character,Integer> map = new HashMap();
    // filling map for t and s string
    for(char c : s.toCharArray())
        map.put(c,0);
    for(char c : t.toCharArray())
    {
        if(map.containsKey(c))
            map.put(c,map.get(c)+1);
        else
            return "";
    }
    
    // Initializing
    int start =0, end=0, minStart=0,minLen = Integer.MAX_VALUE, counter = t.length();
    
    // till last string
    while(end < s.length())
    {
        char c1 = s.charAt(end);
        // if c1 is present in map then reduce the counter and upfdate map
        if(map.get(c1) > 0)
            counter--;
        map.put(c1,map.get(c1)-1);
        
        end++;
        
        // when counter  == 0 we got the pattern 
        while(counter == 0)
        {   
            // once we have the pattern we try to get min length
            if(minLen > end-start)
            {
                minLen = end-start;
                minStart = start;
            }
            
            // slide the window to get optimized version of window with min length
            char c2 = s.charAt(start);
            map.put(c2, map.get(c2)+1);
            
            if(map.get(c2) > 0)
                counter++;
            
            start++;
        }
    }
    // return ans
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
        
        
    }
}
class Solution {
    
    private String generateKey(String s) {
        
    char[] ca = new char[26];

    for (char c : s.toCharArray()) ca[c - 'a']++ ;

    return String.valueOf(ca);
}
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap();
        
        for(String s : strs) {
            
            String key = generateKey(s);
           
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            
            map.get(key).add(s);
           
         }
        
        // Get result from map
        for(List<String> ls : map.values()) ans.add(ls);
        
        return ans;
    }
}
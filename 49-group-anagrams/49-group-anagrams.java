class Solution {
    
    private String generateKey(String s) {
        char[] c = s.toCharArray();
         Arrays.sort(c);
        return String.valueOf(c);
}
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap();
        
        for(String s : strs) {
            
            String key = generateKey(s);
           
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            
            map.get(key).add(s);
           
         }
        
        System.out.println(map);
        
        // Get result from map
        for(List<String> ls : map.values()) ans.add(ls);
        
        return ans;
    }
}
class Solution {
    
    List<List<String>> ans = new ArrayList<>();
    
    Map<String, List<String>> map = new HashMap<>();
    
    private String generateKey(String s){
        
        char[] ca = new char[26];
        
        for (char c : s.toCharArray()) ca[c - 'a']++ ;
        
        return String.valueOf(ca);
        
    }
    
    private String sortString(String s) {
        
        char[] ca = s.toCharArray();
        Arrays.sort(ca);        
        return String.valueOf(ca);       
        
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs.length == 0) return ans;
        
        // Generate Map
        for (String s : strs) {
            
         // sort each String and use it as a key
         //   String key = sortString(s);  
           
            // Generate Key
            String key = generateKey(s);
            
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            
            map.get(key).add(s);
            
        }
            
            // IMP
            for (List<String> lst : map.values()) ans.add(lst); 
            
             return ans;            
            
        }     
     
    }
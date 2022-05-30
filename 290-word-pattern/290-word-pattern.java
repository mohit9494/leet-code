class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        // Length of pattern should match array of s
        if (pattern.length() != s.split(" ").length) return false;
        
        // Map of char with String and String with Char -> Full Match
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        String[] words = s.split(" ");
        
        for (int i = 0; i < pattern.length(); i++) {
            
            char c = pattern.charAt(i);
            String word = words[i];
            
            if (map.containsKey(c)) {
                String temp = map.get(c);
                if (!temp.equals(word)) return false;
            } else {
                
                // check if value is present in set
                if (set.contains(word)) return false; // double mapping
                
                map.put(c, word);
                set.add(word);
                
            }
            
        }
        return true;
    }
}
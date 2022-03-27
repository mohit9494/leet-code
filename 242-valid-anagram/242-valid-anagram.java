class Solution {
    public boolean isAnagram(String s, String t) {
        
         if(s.length() != t.length()) return false;
        
        // Using HashTable -> Handles EveryUnicode Char
        Map<Character, Integer> map = new HashMap();
        
        for(int i = 0; i < s.length(); i++) {
            
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            
        }
        
        for(char c : map.keySet()) {
           if(map.get(c) != 0) return false; 
        }
        
        return true;
        
//         //Hashing or arrays
//         if(s.length() != t.length()) return false;
        
//         int[] table  = new int[26];
        
//         for(int i = 0; i < s.length(); i++){
            
//             table[s.charAt(i) - 'a']++;
//             table[t.charAt(i) - 'a']--;
//         }
        
//         for(int count : table) {
//             if(count != 0) return false;
//         }
        
//         return true;
        
        // sorting
//         char[] s1 = s.toCharArray();
//         char[] s2 = t.toCharArray();
        
//         Arrays.sort(s1);
//         Arrays.sort(s2);
        
//         return Arrays.equals(s1, s2);
    }
}
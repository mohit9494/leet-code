class Solution {
    public boolean isAnagram(String s, String t) {
        
        //Hashing or arrays
        if(s.length() != t.length()) return false;
        
        int[] table  = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        
        for(int count : table) {
            if(count != 0) return false;
        }
        
        return true;
        
        // sorting
//         char[] s1 = s.toCharArray();
//         char[] s2 = t.toCharArray();
        
//         Arrays.sort(s1);
//         Arrays.sort(s2);
        
//         return Arrays.equals(s1, s2);
    }
}
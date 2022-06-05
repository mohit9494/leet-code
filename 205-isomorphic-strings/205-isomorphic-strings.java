class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length()) return false;
        
        int[] sChar = new int[256];
        int[] tChar = new int[256];
        
        for(int i = 0; i < s.length(); i++) {
            
            char a = s.charAt(i);
            char b = t.charAt(i);
            
            if (sChar[a] != tChar[b]) return false;
            
            sChar[a] = i + 1;
            tChar[b] = i + 1;
        }
        return true;
    }
}
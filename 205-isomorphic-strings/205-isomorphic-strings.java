class Solution {
    
    // ASCII characters -> array of size 256
    int[] c1 = new int[256];
    int[] c2 = new int[256];
    
    public boolean isIsomorphic(String s, String t) {
        
        for (int i = 0; i < s.length(); i++) {
                 
            char a = s.charAt(i);
            char b = t.charAt(i);
            
            if (c1[a] != c2 [b]) return false;
            
            c1[a] = i + 1;
            c2[b] = i+1;
            
        }
        
        return true;
    }
}
class Solution {
    // e.g ==> aab || c * a * b
    public boolean dfs(String s, String p, int i, int j) {
        
        // base case
        // if both goes out of bound that means string is matched
        if (i >= s.length() && j >= p.length()) return true;
        
        // if only pattern goes oob means String is yet to be matched fully
        if (j >= p.length()) return false; 
        
        // logic
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        // lets first check the "*" -> this is root of everything
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
         // we have 2 options :: not choose  or  choose (only if match happens)
         return (dfs (s, p , i, j + 2) || (match && dfs (s, p, i + 1, j))) ;
        }
        
        // if its not * -> normal char and matched move forward
        if (match) return dfs(s, p, i+1, j+1);
        
        return false;
        
    }
    
    public boolean isMatch(String s, String p) {
        
        if (s.equals(p)) return true;
        
        return dfs(s, p, 0, 0);
    }
}
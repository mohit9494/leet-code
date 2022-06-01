class Solution {
    public int longestPalindrome(String s) {
        
        int count = 0;
        
        Set<Character> set  = new HashSet();
        
        for (char c : s.toCharArray()) {
            
            if (set.contains(c)) {
                count += 2 ;
                set.remove(c);
            } else {
                set.add(c);
            }
            
        }
        
      if(set.isEmpty()) return count;
        else return count + 1;
    }
}
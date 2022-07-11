class Solution {
    public boolean canPermutePalindrome(String s) {
        
        // only lowercase englisg letters
        // frequency array
        int[] fr = new int[26];
        
        for (char c : s.toCharArray()) {
            
            if (fr[c - 'a'] == 0) {
              fr[c - 'a']++;  
            } else{
                fr[c - 'a']--;
            }
            
        }
        
        // take sum
        int sum = Arrays.stream(fr).sum();
        
        if (s.length() % 2 == 0 ) {
            if (sum != 0) return false;
        }else {
            if (sum != 1) return false;
        }       
        
        return true;
    }
}
class Solution {
    
    List<List<String>> ans = new ArrayList<>();
    
    private boolean isPalindrome(String s, int i, int j) {
        
        while (i <= j) {
        
            if (s.charAt(i++) != s.charAt(j--)) return false;
            
        }
        
        return true;
    }
    
    private void partitionString(String s, int index, List<String> ds) {
        
        if (index >= s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
         
            // If its a palindrome
            if (isPalindrome(s, index, i)){
                
                ds.add(s.substring(index, i + 1));
                       
                partitionString(s, i + 1, ds);
                
                ds.remove(ds.size() - 1);
            }            
            
        }       
        
    }
    
    public List<List<String>> partition(String s) {
        
        partitionString(s, 0, new ArrayList<>()); 
        
        return ans;
    }
}
class Solution {
    
    
    List<List<String>> ans = new ArrayList<>();
    
    private boolean isPalindrome(String s, int start, int end) {
        
        while (start <= end) {
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    
    private void getPartition(String s, int index, List<String> ds) {
        
        if(index >= s.length()) {
            
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            
            if(isPalindrome(s, index, i)) {
                
                ds.add(s.substring(index, i + 1));
                
                getPartition(s, i + 1, ds);
                
                ds.remove(ds.size() - 1);
            }
            
        }
        
        
    }
    
    public List<List<String>> partition(String s) {
        
        getPartition(s, 0, new ArrayList<>());
        
        return ans;
    }
}
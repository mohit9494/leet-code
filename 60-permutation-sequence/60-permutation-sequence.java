class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        
       // Generate the (n - 1)! ?
        // Because first block of size (n-1)!
        for (int i = 1; i < n ; i++) {
         fact = fact * i; 
            nums.add(i);
        }
        
        nums.add(n);
        k = k - 1 ;// 0 based Indexing
        String ans = "";
        
        while (true) {
            
            ans = ans + nums.get(k/fact);  
            nums.remove(k/fact); 
            if (nums.size() == 0) break;
            
            k = k % fact;
            fact = fact / nums.size();
            
            
        }
        return ans;
    }
}
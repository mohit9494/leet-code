class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        if (nums == null || nums.length == 0) return result;
        
        result.add(new ArrayList<Integer>());
        
        for (int num : nums) {
            
            int size = result.size();
            
            for (int j = 0; j < size; j++) {
                
             List<Integer> temp = result.get(j);
             List<Integer> op  = new ArrayList<>(temp);
             op.add(num);
             result.add(op);
            }
         
        }
        
        return result;
    }
}
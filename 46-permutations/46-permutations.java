class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public void getPermute(int[] nums, List<Integer> ds, Set<Integer> set){

        
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return ;
        }
        
        for(int i = 0; i < nums.length; i++) {
            
            if(!set.contains(nums[i])){
                
               set.add(nums[i]); 
                ds.add(nums[i]);
                
                getPermute(nums, ds, set);
                
                ds.remove(ds.size() - 1);
                set.remove(nums[i]);
                
                }
            }
         }
    
    public List<List<Integer>> permute(int[] nums) {
        
        getPermute(nums, new ArrayList<>(), new HashSet<>());
        return ans;
    }
}
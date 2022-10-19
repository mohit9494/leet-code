class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public void helper(int[] a, int target, List<Integer> ds, int index) {
        
        if (index == a.length) {
          if (target == 0) {
                result.add(new ArrayList<>(ds));
            } 
            return;
        }
                      
        
        // select unlimited
        if (a[index] <= target) {
        ds.add(a[index]);
        helper(a, target - a[index], ds, index);
        ds.remove(ds.size() - 1);   
        }
       
        
        // Not select 
        helper(a, target, ds, index + 1);        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        
        helper(candidates, target, new ArrayList<>(), 0);
        
        return result;
        
    }
}
class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public void helper(int[] a, int target, List<Integer> ds, int index, int n) {
        
            if (target < 0 || index >= n ) return;
            if (target == 0) {
                result.add(new ArrayList<>(ds));
                return;
            }            
        
        // select unlimited
        ds.add(a[index]);
        helper(a, target - a[index], ds, index, n);
        ds.remove(ds.size() - 1);
        
        // Not select 
        helper(a, target, ds, index + 1, n);        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        
        helper(candidates, target, new ArrayList<>(), 0, candidates.length);
        
        return result;
        
    }
}
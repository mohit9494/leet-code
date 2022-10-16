class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public void helper(int[] a, int target, List<Integer> ds, int index, int n) {
        
            if (target < 0 || index >= n ) return;
            if (target == 0) {
                result.add(new ArrayList<>(ds));
                return;
            }            
        
        // select
        ds.add(a[index]);
        helper(a, target - a[index], ds, index, n);
        
        // Not select
        ds.remove(ds.size() - 1);
        helper(a, target, ds, index + 1, n);
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if (candidates.length == 0) return result;
        
        helper(candidates, target, new ArrayList<>(), 0, candidates.length);
        
        return result;
        
    }
}
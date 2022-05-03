class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public void helper(int[] candidates, int target, int i, List<Integer> a) {
        
        // base case
        if(i >= candidates.length) {
            
            if(target == 0) {
                ans.add(new ArrayList<>(a)); //IMP
            }
            return ;
        }
        
        // add and remove the element in array
        // Pick up the element
        if(candidates[i] <= target) {
            a.add(candidates[i]);
            helper(candidates, target - candidates[i], i, a);
            a.remove(new Integer(candidates[i]));
        }
        
        // Not Pickup the element
        helper(candidates, target, i + 1, a); 
        
}
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<Integer> arr = new ArrayList<>();
        helper(candidates, target, 0, arr);
        return ans;
    }
}
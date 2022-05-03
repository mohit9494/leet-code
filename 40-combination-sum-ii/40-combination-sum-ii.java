class Solution {
    
    List<List<Integer>> ans = new ArrayList<>(); 
    
    private void helper(int[] candidates, int target, int ind, List<Integer> a){        
        
        // At some point target will be 0 or less than 0
        if(target == 0) {            
            ans.add(new ArrayList<>(a));
            return ;
        }
        
        // index can take value from i to end -> we need to use for loop
        for(int i = ind; i < candidates.length; i++) {            
            // avaoid duplicates;
            if(i > ind && candidates[i] == candidates[i - 1]) continue;            
            // Break the loop - this might happen a lot of times
            if(candidates[i] > target) break;            
            
            a.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, a);
            a.remove(new Integer(candidates[i]));
            
        } 
    
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<Integer> arr = new ArrayList<>();
        
        Arrays.sort(candidates); // IMP
        
        helper(candidates, target, 0, arr);
        
        return ans;
    }
}
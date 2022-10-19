class Solution {  
    
     List<List<Integer>> ans = new ArrayList<>();
    
    public void helper(int[] arr, int target, int index, List<Integer> ds) {
        
        
        
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
                return;
            }
           
        
        
        // select using for loop
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] <= target) {
                ds.add(arr[i]);
                helper(arr, target - arr[i], i + 1, ds);
                ds.remove(ds.size() - 1);  
            }
        }
      
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        helper(candidates, target, 0, new ArrayList<>());
        
        return ans; 
        
    }
}
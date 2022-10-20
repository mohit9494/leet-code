class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public void helper(int[] arr, List<Integer> ds, boolean[] flag){
        if (ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                ds.add(arr[i]);
                helper(arr, ds, flag);
                ds.remove(ds.size() - 1);
                flag[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
      
        helper(nums, new ArrayList<>(), new boolean[nums.length]);
        
        return ans;
    }
}
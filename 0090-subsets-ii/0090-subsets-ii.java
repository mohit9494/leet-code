class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public void helper(int[] arr, int index, List<Integer> ds){
        ans.add(new ArrayList<>(ds));
        
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            ds.add(arr[i]);
            helper(arr, i + 1, ds);
            ds.remove(ds.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ans;
    }
}
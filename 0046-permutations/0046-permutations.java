class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void helper(int[] arr, int index){
      
        if (index == arr.length) {
            List<Integer> temp = new ArrayList<>();
            for (int k : arr) temp.add(k);
            ans.add(temp);
            return;
        }
        
        for (int i = index; i < arr.length; i++) {
                
            swap(arr, i, index);
            helper(arr, index + 1);
            swap(arr, i, index);
            }
        }
    
    
    public List<List<Integer>> permute(int[] nums) {
      
        helper(nums, 0);
        
        return ans;
    }
}
class Solution {
    
    List<List<Integer>> ans = new ArrayList<>(); 
    int min = Integer.MAX_VALUE;
    
    public void helper(int [] arr){
        
        int i = 0;
        int j = 1;
        
        while(j < arr.length) {
            
            int first = arr[i++];
            int second = arr[j++];
            int val = Math.abs(first - second);
            
             if (val == min) {
                //add in the array
                ans.add(Arrays.asList(first, second));
            } else if (val < min) {
                 // found new min
                 min = val;
                 ans.clear();
                 ans.add(Arrays.asList(first, second));
             } else {
                 // Do nothing
             }
            
            
        }
        
    }
    
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        // Sort the array
        Arrays.sort(arr);
        
        helper(arr);
        
        return ans;
        
    }
}
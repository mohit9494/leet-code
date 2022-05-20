class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int i = 0;
        int j = 1;
        int min = Integer.MAX_VALUE;
        
        while(j < arr.length) {
            
             int first = arr[i++];
             int second = arr[j++];

             int val = Math.abs(second - first);
             
             if (val == min) {
                 ans.add(Arrays.asList(first, second));
             } else if (val < min) {
                 // fond new min
                 min = val;
                 ans.clear();
                 ans.add(Arrays.asList(first, second));
             }

        }
        
        return ans;
    }
}
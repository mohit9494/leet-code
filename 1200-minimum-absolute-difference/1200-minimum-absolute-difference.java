class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // sort the array
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length - 1; i++) {
            
            int a = arr[i];
            int b = arr[i + 1];
            int diff = Math.abs(b - a);
            
            if (diff < min) {
                min = diff;
                result.clear();
                result.add(List.of(a, b));
            } else if (diff == min) {
               result.add(List.of(a,b));
            }
            
        }
        return result;
    }
}
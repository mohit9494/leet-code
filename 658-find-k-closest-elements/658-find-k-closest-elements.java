class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
        // Two pointer
        int i = 0;
        int j = arr.length - 1;
        
        while (j - i +  1 > k) {
            
            int disl = Math.abs(arr[i] - x);
            int disr = Math.abs(arr[j] - x);
            
            if (disl > disr) {
                // Move to left
                i++;
            } else {
                // If equal or disr is more
                j--;
            }
            
        }
        
        List<Integer> result = new ArrayList<>();
       // Now we are at proper i and j position
        for(int a = i; a <= j; a++) {
         result.add(arr[a]);   
        }
        
        return result;
    }
}
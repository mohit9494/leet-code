class Solution {
    
    private List<Integer> countSort(int[] arr) {
        
        int size = 2*(int)(Math.pow(10,6));
        size++;
        
        int[] count = new int[size];
        int shift = (int)Math.pow(10,6);
        
        for (int i : arr) {
            count[i + shift] = 1;
        }
        
        List<Integer> sorted = new ArrayList<>();
        
        for(int i = 0; i< count.length; i++) {
            if(count[i] == 1) sorted.add(i - shift);
        }
        
        return sorted;
    }
    
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // sort the array using counting sort
        List<Integer> sorted = countSort(arr);
        
        // sort the array
        // Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < sorted.size() - 1; i++) {
            
            int a = sorted.get(i);
            int b = sorted.get(i + 1);
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
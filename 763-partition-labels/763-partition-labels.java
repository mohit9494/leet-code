class Solution {
    public List<Integer> partitionLabels(String s) {
        
        // Create frequency map
        Map<Character, Integer> map = new HashMap<>();
        int k = 0;
        for (char c : s.toCharArray()) map.put(c, k++);
        
        List<Integer> result = new ArrayList<>();
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {            
            char c = s.charAt(i);           
            int endidx = map.get(c);            
            end = Math.max(end, endidx);
            
            // if I reached end - got the perfect partition
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }           
            
        }
        
        return result;
        
    }
}
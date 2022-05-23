class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    private void helper(int[] nums, List<Integer> ds, Map<Integer, Integer> map) {
        
        if(ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return; 
        }
        
        for(int i : map.keySet()) {
            
            Integer num = i;
            Integer count = map.get(i);
            
            //If count == 0 then skip
            if(count == 0) continue;
            
            ds.add(num);
            map.put(num, count - 1);
            
            helper(nums, ds, map);
            
            ds.remove(ds.size() - 1);
            map.put(num, count);
            
        }        
        
    }
     
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        // convert the nums into HashMap
        Map<Integer, Integer> map = new HashMap();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        helper(nums, new ArrayList<>(), map);
        
        return ans;
        
    }
}
class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int ans = Integer.MAX_VALUE;
        
        if(cards == null || cards.length == 0) return ans;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        
        for (int i = 0; i < cards.length; i++) {
            
        int num = cards[i];
            
        if(map.containsKey(num)) {
            ans = Math.min(ans, i - map.get(num) + 1);
        }
            map.put(num, i);
            
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
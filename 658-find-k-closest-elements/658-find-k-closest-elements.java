class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // we want smallest distance from x :: we need K eleemnts
        // Max Priority Queue
        Queue<Integer> q = new PriorityQueue<>((a, b) -> {
            int da = Math.abs(a - x);
            int db = Math.abs(b - x);
            
            if(da == db) {
                // If distance are equal -> compare based on their values
                return Integer.compare(b,a);
            } 
            
            return Integer.compare(db, da);            
        });
            
        for (int i : arr) {
            q.add(i);
            if (q.size() > k) q.poll();
            
        }
        
        System.out.println(q);
        
        // we have the output in pq
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) result.add(q.poll());
        
        Collections.sort(result);
        
        return result;
    }
}
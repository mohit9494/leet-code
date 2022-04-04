class Solution {
    
    // private Map<Integer, Integer> map = new HashMap<>(Map.of(0,0,1,1));
    
    public int fib(int n) {
     
    // Iterative approach
    if (n <= 1 ) return n;
        
    int prev1 = 1;
    int prev2 = 0;
    int curr = 0;
        
    for (int i = 2; i <= n ; i++) {
        curr = prev1 + prev2;
        prev2 = prev1;
        prev1 = curr;
    }
        
    return curr;
    
    // worst
    //return fib(n-1) + fib(n-2);
    
    // cache Tabulation
//     int[] cache = new int[n+1];
//     cache[1] = 1;
    
//     for(int i = 2; i <= n; i++) {
//         cache[i] = cache[i - 1] + cache[i - 2];
//     }
    
//     return cache[n];
        
        // Using Memoization
//         if (map.containsKey(n)) {
//             return map.get(n);
//         }
        
//         map.put(n, fib(n-1) + fib(n-2));
        
//         return map.get(n);
    }
}
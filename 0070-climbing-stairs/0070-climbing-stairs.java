class Solution {

    
    public int climbStairs(int n) {
      if (n <= 2) return n;
      
      int a = 1;
      int b = 2;
      int c = 0;
        
      for (int i = 3; i <= n; i++) {
          c = b + a;
          a = b;
          b = c;
      }
     
      return c;  
    }
}
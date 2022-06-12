class Solution {
    public double myPow(double x, int n) {
        
      long N = n;
        
      if (N == 0) return 1.0;
        
     if (N < 0) {
         N = -N;
         x = 1 / x;
     }
        
        double ans = 1.0;
        
        while (N > 0) {
            
            // If n is even
            if (N % 2 == 0) {
                
                x = x * x;
                N =  N / 2;
                
            } else  {
                
             ans = ans * x;
             N = N - 1;
                
            }
        }
       
        return ans;
    }
}
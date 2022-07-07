class Solution {
    
    private double helper(double x, long n){
        
        if (n == 0) return 1.0;
        
       return n % 2 == 0 ? helper(x * x, n/2) :  x * helper(x * x, n/2);
        
    }
    
    public double myPow(double x, int n) {
        
        long N = n;
        
        if (n < 0) {
            N = -N;
            x = 1/x;
        }
        
        return helper(x, N);
        
    }
}
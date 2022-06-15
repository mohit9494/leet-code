class Solution {

    public int kthGrammar(int n, int k) {
        
      // base 
     if (n == 1) return 0;
        
     // Chcek kth position
     // If k is odd same value else opposite value
     
     if (k % 2 == 1) {
         return kthGrammar(n - 1, (k + 1)/2 );
     } else {
         // k is even value will be flipped from previous
         int val = kthGrammar(n - 1, k / 2);
         return val == 0 ? 1 : 0;
     }
        
    }
}
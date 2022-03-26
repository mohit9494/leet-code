class Solution {
    
    
    private int getSquare(int num) {
        int ans = 0;
        
        while(num > 0) {
            
            int digit = num % 10;
            ans += digit * digit;
            num = num / 10;
            
        }
        
        return ans;
    }
    
    public boolean isHappy(int n) {
        
        boolean isHappy = true;
        
        if (n == 1) return isHappy;
        
        int slow = n;
        int fast = n;
        
        while(fast != 1 && getSquare(fast) != 1) {
            
          fast = getSquare(getSquare(fast));  
            slow = getSquare(slow);
            
            if(slow == fast) {
                isHappy = false;
                return isHappy;
            }
        }
        
        return isHappy;
    }
}
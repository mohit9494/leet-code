class Solution {
    
    public static int results[] = new int[100]; 
    
  
        
        
    
    public int climbStairs(int n) {
        if(n<0){        
            return 0;       
        }
        
        if(n==0){
            return 1;   
        }
        
        if(results[n]!=0){      
            return results[n]; 
        }
        
        int onePaths = climbStairs(n-1); 
        int twoPaths = climbStairs(n-2); 
        results[n] = onePaths + twoPaths; 
        return results[n];
        
        
    
}}
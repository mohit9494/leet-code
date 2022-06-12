class Solution {
    public int maxArea(int[] height) {
        
        int maxi = Integer.MIN_VALUE;    
        int i = 0, j = height.length - 1;
    
    while(i < j) {
        
        int w = j - i;
        int h = Math.min(height[j], height[i]);
        
        maxi = Math.max(maxi, w * h);
        
        if (height[i] < height[j]) i++;
        else j--;      
        
        
    }
    
           
       
       return maxi;
        
    }
}
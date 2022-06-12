class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> ans = new ArrayList<>();
        
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        
       // This is continuous process
    
        while (top <= bottom && left <= right) {
            
         // Left ------> Right   
          for (int i = left; i <= right; i++) {
              ans.add(matrix[top][i]);
          } 
          top++;
          if (bottom < top) break;
          
        // top -------> bottom
        for (int i = top; i <= bottom; i++) {
            ans.add(matrix[i][right]);
        }
        right--;
        if(right < left) break;
        
        // right --------> left
        for (int i = right; i >= left; i--) ans.add(matrix[bottom][i]);
        bottom--;
        if (bottom < top) break;
        
        // bottom -------> top
        for (int i = bottom; i >= top; i--) ans.add(matrix[i][left]);
        left++;
        if (right < left) break;
            
        }
        
        return ans;
    }
}
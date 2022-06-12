class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        int[] ans = new int[m * n];
        
        int z = 0;
        int i = 0, j = 0;
        boolean up = true;
        
        while (i < m && j < n) {
           
            if (up) {
              
                // decrease the row increase the col
                while (i > 0 && j < n - 1) {
                    ans[z++] = mat[i--][j++];
                }
                
                // here i = 0 or j = n -1 or both
                ans[z++] = mat[i][j];
                
                // move forward
                if (j == n-1) i++;
                else if (i == 0) j++;
                
            } else {
                
                // Going down
                // Increase the row  and decrese the cols
                while (i < m-1 && j > 0) {
                    ans[z++] = mat[i++][j--];
                }
                
                // Hit the last
                ans[z++] = mat[i][j];
                
                // Move forward
                if (i == m-1) j++;
                else if (j == 0) i++;
                
            }
            
            up = !up;
        }
        
        return ans;
    }
}
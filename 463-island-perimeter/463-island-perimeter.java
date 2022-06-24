class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int peri = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if (grid[i][j] == 1) {
                    
                    // calculate water edge
                    if (i == 0 || grid[i - 1][j] == 0) peri++;                    
                    if (i == m - 1 || grid[i + 1][j] == 0) peri++;
                    if (j == 0 || grid[i][j - 1] == 0) peri++;
                    if (j == n - 1 || grid[i][j + 1] == 0) peri++;                    
                    
                }
                
                
            }
        }
        
        return peri;
        
    }
}
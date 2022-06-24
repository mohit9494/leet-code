class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int peri = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if (grid[i][j] == 1) {
                    
                    // when you hit the land - just multiply by 4
                    peri += 4;
                    
                    // Just Check UP and Left is land or not
                    // If it is then Just subtract 2 :: two walls matched
                    
                    if(i > 0 && grid[i - 1][j] == 1) peri -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) peri -= 2;
                    
                    // // calculate water edge
                    // if (i == 0 || grid[i - 1][j] == 0) peri++;                    
                    // if (i == m - 1 || grid[i + 1][j] == 0) peri++;
                    // if (j == 0 || grid[i][j - 1] == 0) peri++;
                    // if (j == n - 1 || grid[i][j + 1] == 0) peri++;                    
                    
                }
                
                
            }
        }
        
        return peri;
        
    }
}
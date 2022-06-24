class Solution {
    
    private void dfs(char[][] grid, int r, int c) {
        
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return ;
        
        grid[r][c] = '0';
        
        // Move all dir
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);       
        
        
    }
    
    public int numIslands(char[][] grid) {
        
        // this is classic DFS
        if (grid == null || grid.length == 0) return 0;
        
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               
                // we got the starting point of Island
                // Just spread in all dir till we get some water :: 0                
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
                
            }            
            
        }
        
        return count;
    }
}
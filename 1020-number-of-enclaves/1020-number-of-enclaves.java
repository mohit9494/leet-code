class Solution {
    
    public void dfs(int i, int j, int[][] grid, int[][] v) {
        
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
           || grid[i][j] == 0 || v[i][j] == 1) return;
        
        v[i][j] = 1;
        
        // move in all 4 dir
        dfs(i + 1, j, grid, v);
        dfs(i - 1, j, grid, v);
        dfs(i, j + 1, grid, v);
        dfs(i, j - 1, grid, v);

    }
    
    public int numEnclaves(int[][] grid) {
     
        // this is similar to surrounded regions
        // capture the boundry 1's first and trigger DFS
        // mark them as visited in vis array then scan grid to find out number of enclaves
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] v = new int[m][n];
        
        // first row, last row
        for (int j = 0; j < n; j++){
            if(grid[0][j] == 1 && v[0][j] == 0) {
                dfs(0, j, grid, v);
            }
             if(grid[m - 1][j] == 1 && v[m - 1][j] == 0) {
                dfs(m - 1, j, grid, v);
            }
        }
        
        // first col last col
        for (int i = 0; i < m; i++){
            if(grid[i][0] == 1 && v[i][0] == 0) {
                dfs(i, 0, grid, v);
            }
             if(grid[i][n-1] == 1 && v[i][n - 1] == 0) {
                dfs(i, n - 1, grid, v);
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && v[i][j] == 0) {
                    count = count + 1;
                }
            }
        }
        
        return count;
    }
}
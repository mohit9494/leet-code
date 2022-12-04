

class Solution {
    
    public void dfs(int row, int col, int[][] v, char[][] grid) {
        
        if (row < 0 || row >= grid.length
            || col < 0 || col >= grid[0].length || v[row][col] == 1 || grid[row][col] == '0') {
            return ;
        }
        
        v[row][col] = 1;
        
        // Move into all 4 direction
        dfs(row + 1, col, v, grid);
        dfs(row - 1, col, v, grid);
        dfs(row, col + 1, v, grid);
        dfs(row, col - 1, v, grid);
        
    }
    
    public int numIslands(char[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
       int[][] v = new int[m][n];
       int ans = 0;
      // we can use both bfs and dfs
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
           // if I find land and not visited then that will be starting point
           if (grid[i][j] == '1' && v[i][j] == 0) {
             ans++;
             dfs(i, j, v, grid);
           }
            
         } 
      }   
      return ans;
    }
}
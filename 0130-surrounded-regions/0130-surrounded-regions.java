class Solution {
    
    public void dfs(char[][] arr, int[][] v, int i, int j) {
        
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length
          || arr[i][j] == 'X' || v[i][j] == 1) return ;
        
        v[i][j] = 1;
        
        // Move in all 4 dir
        dfs(arr, v, i - 1, j);
        dfs(arr, v, i + 1, j);
        dfs(arr, v, i, j + 1);
        dfs(arr, v, i, j - 1);
    }
    
    public void solve(char[][] board) {
        
        // Find the O region on boundry line
        // Find its connected component using DFS - mark it
        // remaining Os canbe converted 
        int m = board.length;
        int n = board[0].length;
        int[][] v = new int[m][n];
        
        // first row and last row
        for (int j = 0; j < n; j++) {
         if (board[0][j] == 'O' && v[0][j] == 0) {
             dfs(board, v, 0, j);
         }
         
         if (board[m - 1][j] == 'O' && v[m - 1][j] == 0) {
             dfs(board, v, m - 1, j);
         }     
        }
        
        // first col and last col
        for (int i = 0; i < m; i++) {
         if (board[i][0] == 'O' && v[i][0] == 0) {
             dfs(board, v, i, 0);
         }
         
         if (board[i][n - 1] == 'O' && v[i][n - 1] == 0) {
             dfs(board, v, i , n - 1);
         }     
        }
        
        // scan visit and transform board
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && v[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}
class Solution {
    
    List<List<String>> ans = new ArrayList<>();
    
    public void solve(int col, char[][] board, int[] leftRow, int[] ud, int[] ld) {
        
        int n = board.length;
        
        if (col >= n) {
            
            List<String> res = new ArrayList<>();
            
            // Convert char array to String and add in list
            for(char[] c : board) res.add(new String(c));
            
            // Add res in final answer
            ans.add(res);
            return;
        }
        
        for (int row = 0; row < n; row++) {
            
            if (leftRow[row] == 0 && 
                ud[row + col] == 0 && 
                ld[n - 1 + col - row] == 0) {
              
             board[row][col] = 'Q';   
             leftRow[row] = 1;
             ud[row + col] = 1;
             ld[n - 1 + col - row] = 1;
                
            solve(col + 1, board, leftRow, ud, ld);
                
             board[row][col] = '.';   
             leftRow[row] = 0;
             ud[row + col] = 0;
             ld[n - 1 + col - row] = 0;
                
            }            
            
        }
        
    }
    
    public List<List<String>> solveNQueens(int n) {
        
        // Create the board
        char[][] board = new char[n][n];
        
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // validators
        int[] leftRow = new int[n];
        int[] ud = new int[2 * n - 1];
        int[] ld = new int[2 * n - 1];
        
        solve(0, board, leftRow, ud, ld);
        
        return ans;
    }
}
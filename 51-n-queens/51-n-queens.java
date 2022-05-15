class Solution {
    
    List<List<String>> ans = new ArrayList<>();
    
    private List<String> construct(char[][] board) {
        
        List<String> res = new ArrayList<>();
        
        for(char[] r : board) res.add(new String(r));
        
        return res;
    }
    
    private void solve(int col, char[][] board, int[] leftRow, int[] ud, int[] ld){
        
        if(col >= board.length){
            ans.add(construct(board));
            return;
        }
        
        for (int row = 0; row < board.length; row++) {
            
            if(leftRow[row] == 0 &&
              ld[row + col] == 0 &&
              ud[board.length - 1 + col - row] == 0) {
                
                board[row][col] = 'Q';
                leftRow[row] = 1;
                ld[row + col] = 1;
                ud[board.length - 1 + col - row] = 1;
                
                solve(col + 1, board, leftRow, ud, ld);
                
                board[row][col] = '.';
                leftRow[row] = 0;
                ld[row + col] = 0;
                ud[board.length - 1 + col - row] = 0;
                
            }
            
            
        }
        
    }     
    
    public List<List<String>> solveNQueens(int n) {
        
        // Create a board
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
    // validators
    int[] leftRow = new int[n];
    int[] upperDiagonal = new int[2*n - 1];
    int[] lowerDiagonal = new int[2 * n - 1];
        
    solve(0, board, leftRow, upperDiagonal, lowerDiagonal);
    
    return ans;
        
    }
}
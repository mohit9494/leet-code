class Solution {
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        
        for (int i = 0; i < 9; i++) {
          
            if(board[row][i]  == c) return false;
            
            if(board[i][col] == c) return false;
            if(board[ 3 * (row/3) + i/3][3 * (col/3) + i%3] == c) return false;
        }
        
     return true; 
        
    }
    
    public boolean solve(char[][] board) {
        
      // Find the empty spot
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] == '.') {
                    
                    // Found the empty spot
                    // Check for all the numbers from 1 to 9 
                    for (char c = '1'; c <= '9'; c++) {
                        
                        // If its a valid character
                        if (isValid(board, i, j, c)) {
                            
                            board[i][j] = c;
                            
                            boolean flag = solve(board);
                            if (flag) return true; // Got the only answer needed
                            else board[i][j] = '.'; // else restore                            
                            
                        }                       
                        
                    }                    
                    
                    // At this point the spot is '.' but not able to fill any number between 1 to 9
                    // return false as this combination is not gonnaa work at all
                    return false;
                }
                
            }
        }
        // There is no spot to fill -> Board is solved
        return true;
    }
    
    public void solveSudoku(char[][] board) {
        
        // Board full of chars
        // . for empty
        
        solve(board);
        
    }
}
class Solution {
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        
        for (int i = 0; i < 9; i++) {
            
            if (board[row][i] == c) return false; 
            
            if (board[i][col] == c) return false;
            
            int rowBlock = 3 * (row/3);
            int colBlock = 3 * (col/3);
            
            int rowPos = rowBlock + i/3;
            int colPos = colBlock + i%3;
            
            if (board[rowPos][colPos] == c) return false;
        }
        
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {            
            for (int j = 0; j < 9; j++) {
                
                // Find the filled Spot
                if (board[i][j] != '.') {
                    
                    char c = board[i][j];
                    
                    // Before validation make that spot Blank
                    board[i][j] = '.';
                    
                    if(isValid(board, i, j, c)) {
                        // Again restore the value;
                        board[i][j] = c;
                    } else {                       
                        return false;
                    }                                      
                    
                }                
                     
            }
        }
        return true;
    }
}
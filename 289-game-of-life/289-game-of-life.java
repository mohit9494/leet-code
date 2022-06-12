class Solution {
    public void gameOfLife(int[][] board) {
        
        int m =  board.length;
        int n = board[0].length;
        
        // 0 ----> 1 ===> 3
        // 1 -----> 0 ====> -3
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
              
            int live = 0;
                
            int top = i == 0 ? 0 : i - 1;
            int bottom = i == m-1 ? m - 1 : i + 1;
            int left = j == 0 ? 0 : j - 1;
            int right = j == n - 1 ? n - 1 : j + 1;
                
          for (int row = top; row <= bottom; row++){
                for (int col = left; col <= right; col++) { 
                    
                   if (!(row == i && col == j)) {
                       
                       int val = board[row][col];
                       
                       if (val == 0 || val == 3) continue;
                       else if (val == 1 || val == -3) live = live + 1;
                       
                   } 
                    
                }
          }
                
            //  we get live count
            if ((live < 2 || live > 3) && board[i][j] == 1) {
                // make it dead
                board[i][j] = -3;
            } else if (live == 3 && board[i][j] == 0) {
                board[i][j] = 3;
            }
                
                
            }          
            
        }
        
// Restore the ans
   for(int i = 0; i < m; i++) {
        for (int j = 0; j< n; j++) {

            if (board[i][j] == 3) board[i][j] = 1;
            else if (board[i][j] == -3) board[i][j] = 0;
   }
}
        
        
    }
}
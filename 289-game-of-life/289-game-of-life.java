class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        int[][] ca = new int[m][n];
        
        for(int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                ca[i][j] = board[i][j];
            }
        }
        
        // System.out.println(Arrays.deepToString(ca));
        
        for(int i = 0; i < m; i++) {
            for (int j = 0; j< n; j++) {
                
                int live = 0;
                
                int top = i == 0 ? 0 : i - 1;
                int bottom = i == m - 1 ? m - 1 : i + 1;
                int left = j == 0 ? 0 : j - 1;
                int right = j == n - 1 ? n - 1 : j + 1;
                
                for (int row = top; row <= bottom; row++){
                    for (int col = left; col <= right; col++) {
                        if(!(row == i && col == j)){
                           live = live + ca[row][col] ;  
                        }
                    }
                }
                
                // we get the live values
                // its time to use them
                if (live < 2 || live > 3) {
                    board[i][j] = 0;
                } else if (live == 3) {
                    board[i][j] = 1;
                }
                
            }
        }
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean isCol = false;
        
        for (int i = 0; i < matrix.length; i++) {
            
            if (matrix[i][0] == 0) isCol = true;
            
            for (int j = 1; j < matrix[0].length; j++) {
                
                if(matrix[i][j] == 0) {
                    
                    // flag the first cell in the row
                    matrix[i][0] = 0;
                    // flag the first cell in the cols
                    // we will never revisit this place 
                    matrix[0][j] = 0;
                }
                
            }
        }
        
        System.out.println(Arrays.deepToString(matrix));
        
        // prepare the answer // check rows and cols;
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
        
     // time to check first row and col
    if(matrix[0][0] == 0) {
        for (int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
    }
        
    // check for first col
     if(isCol) {
         for(int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
     }   
        
    }
}
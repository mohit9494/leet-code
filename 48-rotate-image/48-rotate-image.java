class Solution {
    
    private void reverseRow(int[] row){
        
        int i = 0;
        int j = row.length - 1;
        
        while (i < j) {
            
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;            
            i++;
            j--;
        }
        
    }
    
    public void rotate(int[][] matrix) {        
        
        // Transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i >= j) continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Reverse each Row
        for (int i = 0; i < matrix.length; i++) {
            
            // Reverse Ith Row
            int[] row = matrix[i];
            reverseRow(row);
            
        }
        
        
    }
}
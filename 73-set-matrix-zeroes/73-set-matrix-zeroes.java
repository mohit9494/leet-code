 public class Solution {
 public void setZeroes(int[][] matrix) {
     // check initial condition
     if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
     
     // Get rows and cols 
     int m = matrix.length, n = matrix[0].length;
     
     // set flag for first row and cols
     boolean row = false, col = false;
     
     // set up the marker
     for (int i = 0; i < m; i++)
         for (int j = 0; j < n; j++){
             if (matrix[i][j] == 0) {
                 matrix[0][j] = 0;
                 matrix[i][0] = 0;
                 if (i == 0) row = true;
                 if (j == 0) col = true;
             }
         }
     
     // check all row
     for (int i = 1; i < m; i++){
         if (matrix[i][0] == 0){
             for (int j = 1; j < n;j++)
                 matrix[i][j] = 0;
         }
     }
     
     // check all cols
     for (int j = 1; j < n; j++){
         if (matrix[0][j] == 0){
             for (int i = 1; i < m; i++)
                 matrix[i][j] = 0;
         }
     }
     
     // Change First row and col
     if (row){
         for (int j = 0; j < n; j++)
             matrix[0][j] = 0;
     }
     if (col){
         for(int i = 0; i < m; i++)
             matrix[i][0] = 0;
     }
     
 }
 }
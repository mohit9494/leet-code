class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Initial Max Size
        int max = 0;
        
        // Move through the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1') {
                    int l = 1;
                    boolean flag = true;
                    while (i + l < m && j + l < n && flag) {
                        
                        // check all the row elements
                        for (int k = j + l; k >= j; k--) {
                            if (matrix[i + l][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        
                        // check all the col elements
                        for (int k = i + l; k >= i; k--) {
                            if (matrix[k][j + l] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        
                     if (flag) l++;
                        
                    }
                    
                    max = Math.max(max, l);
          }
            }
        }
        
        return max * max;
    }
}
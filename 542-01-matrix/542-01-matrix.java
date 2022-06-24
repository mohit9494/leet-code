class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        // Using DP
        int m = mat.length;
        int n = mat[0].length;
        int INF = m + n + 1;
        
        
        // First Move Up and Left -> Get the Min Distance
        for (int i = 0; i < m; i++) {
            for (int j = 0; j< n; j++) {
             
            int up = INF, left = INF;
                
             if (mat[i][j] == 0) continue;
             
             if (i - 1 >= 0 ) up = mat[i - 1][j];
             if (j - 1 >= 0) left = mat[i][j - 1];
                
             mat[i][j] = Math.min(up, left) + 1;
            }
        }
        
        // Do it for right and bottom
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j>= 0; j--) {
                
                int down = INF, right = INF;
                
                if (mat[i][j] == 0) continue;
                
                if (i < m-1) down = mat[i +  1][j];
                if (j < n - 1) right = mat[i][j + 1];
                
                mat[i][j] = Math.min(mat[i][j], Math.min(right, down) + 1);
            }
        }
        
        return mat;
    }
}
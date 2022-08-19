class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        int[] temp = new int[n];
        temp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                 temp[j] = 0;
                 continue;
                }
                if (i == 0 && j == 0) continue;
                if (j - 1 >= 0) {
                  temp[j] = dp[j] + temp[j - 1];  
                }                
            }
            dp = temp;
        }
        
        return temp[n-1];
    }
}
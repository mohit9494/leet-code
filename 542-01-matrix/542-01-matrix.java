class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        // Iterate over the matrix and mark all the 1 to be -1
        int m = mat.length;
        int n =mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {            
            for (int j = 0; j < n; j++) {  
               //add all 0 to queue, they are one level now for BFS
               if (mat[i][j] == 0) q.add(new int[]{i, j});
               if(mat[i][j] == 1) mat[i][j] = -1; 
            }            
        }
        
        int dist = 1;
        
        while (!q.isEmpty()) {
            
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                
              int[] na = q.poll();
              int nr = na[0];
              int nc = na[1];
                
              if (nr > 0 && mat[nr - 1][nc] == -1) {
                  mat[nr - 1][nc] = dist;
                  q.add(new int[]{nr - 1, nc});
              }
              if (nr < m - 1 && mat[nr + 1][nc] == -1){ 
              mat[nr + 1][nc] = dist;
               q.add(new int[] {nr + 1, nc});}
                  
              if (nc > 0 && mat[nr][nc - 1] == -1) {
                  mat[nr][nc - 1] = dist;
                  q.add(new int[]{nr, nc - 1});
              }
              if (nc < n - 1 && mat[nr][nc + 1] == -1) {
                   mat[nr][nc + 1] = dist;
                  q.add(new int[]{nr, nc + 1});
              }
                 
                
            }  
            
            dist++;
            
        }
        
        return mat;
    }
}
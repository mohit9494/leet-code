class Solution {
    public boolean checkValid(int[][] matrix) {
        
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {            
            // Before each and evry row starts            
           Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();            
            for (int j = 0; j < n; j++) {
                
              if (!row.add(matrix[i][j]) || !col.add(matrix[j][i])) return false;
                
            }
        }
        return true;
    }
}
class Solution {
    
    public void dfs (int i, int j, int bi, int bj, List<String> ls, int[][] grid, int[][] v) {
        
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
           || grid[i][j] == 0 || v[i][j] == 1) return;
        
        v[i][j] = 1;
        ls.add(toString(i - bi, j - bj));
        
        // move int all 4 dir with same base -> dir must be same seq
        dfs(i, j + 1, bi, bj, ls, grid, v);
        dfs(i + 1, j, bi, bj, ls, grid, v);
        dfs(i, j - 1, bi, bj, ls, grid, v);
        dfs(i - 1, j, bi, bj, ls, grid, v);
    }
    
    public String toString(int i, int j) {
        return i + " " + j;
    }
    
    public int numDistinctIslands(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] v = new int[m][n];
        Set<List<String>> set = new HashSet<>();
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && v[i][j] == 0) {
                    // get the base point 
                    // create new list and add them in the set
                    List<String> ls = new ArrayList<>();
                    int bi = i;
                    int bj = j;
                    
                    dfs(i, j, bi, bj, ls, grid, v);
                        
                    set.add(ls);
                }
            }
        }
        
        return set.size();
    }
}
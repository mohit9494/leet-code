 class Node {
    int first;
    int second;
   public Node(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    public void bfs(int row, int col, int[][] v, char[][] grid) {
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col));
        v[row][col] = 1;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dir = {{0,1}, {0,-1}, {1,0},{-1,0}};
        while (!q.isEmpty()) {
            
            Node node = q.poll();
            int r = node.first;
            int c = node.second;
            
            for (int k = 0; k < 4; k++) {
                  int nr = r + dir[k][0];
                   int nc = c + dir[k][1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && 
                       grid[nr][nc] == '1' && v[nr][nc] == 0) {                        
                         v[nr][nc] = 1;
                          q.add(new Node(nr, nc));                   
                 }
            }
     
        }
        
    }
    
    public int numIslands(char[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
       int[][] v = new int[m][n];
       int ans = 0;
      // we can use both bfs and dfs
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
           // if I find land and not visited then that will be starting point
           if (grid[i][j] == '1' && v[i][j] == 0) {
             ans++;
             bfs(i, j, v, grid);
           }
            
         } 
      }
       
      
      return ans;
    }
}
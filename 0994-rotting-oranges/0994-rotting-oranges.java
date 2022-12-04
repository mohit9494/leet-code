class Node {    
    int r;
    int c;
    int t;
    
    public Node(int r, int c, int t) {
        this.r = r;
        this.c = c;
        this.t = t;
    }        
}

class Solution {
    
    public int bfs(Queue<Node> q, int[][] grid, int[][] v) {
        
        int mini = 0;
        
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while (!q.isEmpty()) {
            
            Node node = q.poll();
            int r = node.r;
            int c = node.c;
            int t = node.t;
            mini = t;
            
            for (int k = 0; k < 4; k++) {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                
                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length 
                    && grid[nr][nc] == 1 && v[nr][nc] == 0) {
                    v[nr][nc] = 2;
                    q.add(new Node(nr, nc, t + 1));
                }
            }
        }
        
        return mini;
    }
    
    public int orangesRotting(int[][] grid) {
        
        // Get all the rotton orages as the starting point and start simultenuouslt level-wise
        // BFS
        int m = grid.length;
        int n = grid[0].length;
        Queue<Node> q = new LinkedList<>();
        int[][] v = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                    v[i][j] = 2;
                }
            }
        }
        
        ans = bfs(q, grid, v);
        
        // check if all are rotton;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (v[i][j] != 2) return -1;
                }
            }
        }
        
        return ans;
    }
}
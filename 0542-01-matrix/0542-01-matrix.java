class Node {
    int r;
    int c;
    int d;
    
    public Node (int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

class Solution {
    
    public void bfs(int[][] mat, int[][] v, Queue<Node> q, int[][] dis) {
        
        int[][] dir = {{0,1}, {0,-1},{1,0},{-1,0}};
        
        while (!q.isEmpty()) {
            
           Node node = q.poll(); 
           int r = node.r;
           int c = node.c;
           int d = node.d;
            
           // add int the dis array
           dis[r][c] = d;
            
           for (int k = 0; k < 4; k++) {
               
               int nr = r + dir[k][0];
               int nc = c + dir[k][1];
               
               if(nr >= 0 && nr < mat.length && nc >=0 && nc < mat[0].length
                 && v[nr][nc] == 0) {
                   v[nr][nc] = 1;
                   q.add(new Node(nr, nc, d + 1));
               }
           }
            
        }      
        
    }
    
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        Queue<Node> q = new LinkedList<>();
        int[][] v = new int[m][n];
        int[][] dis = new int[m][n];
        // collect all the 0s and add them in the queue
        // since there distance is 0 from self
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    v[i][j] = 1;
                    q.add(new Node(i, j , 0));
                }
            }
        }
        
        bfs(mat, v, q, dis);
        
        return dis;
    }
}
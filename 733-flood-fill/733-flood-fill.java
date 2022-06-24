class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if (image[sr][sc] == color) return image;
        
        // using bfs
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        
        int startPixel = image[sr][sc];
        
        while (!q.isEmpty()) {
            
            int[] na = q.poll();
            int nr = na[0];
            int nc = na[1];
            
            if (nr < 0 || nr >= image.length || nc < 0 || nc >= image[0].length || 
                image[nr][nc] != startPixel) continue;
            
            image[nr][nc] = color;
            
            q.add(new int[]{nr - 1, nc});
            q.add(new int[]{nr + 1, nc});
            q.add(new int[]{nr, nc - 1});
            q.add(new int[]{nr, nc + 1});
            
        }
        
        return image;
    }
}
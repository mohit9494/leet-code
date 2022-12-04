class Solution {
    
    public void dfs(int[][] image, int o, int n, int i, int j) {
        
        // base condition
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != o || image[i][j] == n) return; 
        
        image[i][j] = n;
        
        // move in 4 dir
        dfs(image, o, n, i + 1, j);
        dfs(image, o, n, i - 1, j);
        dfs(image, o, n, i, j + 1);
        dfs(image, o, n, i, j - 1);
        
        
    } 
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        // get the original color
        int original = image[sr][sc];
        
        // u can use new color as a flag for visited
        // perform dfs for floodfill
        dfs(image, original, color, sr, sc);
        
        return image;
    }
}
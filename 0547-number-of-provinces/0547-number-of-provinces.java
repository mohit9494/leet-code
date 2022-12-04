class Solution {
    
    public void dfs(int i, boolean[] v, int[][] arr) {
        
        v[i] = true;
        
        // get all its neighbours and if not visited perform dfs
        for (int j = 0; j < arr.length; j++) {
          if (arr[i][j] == 1 && v[j] != true) {
              dfs(j, v, arr);
          }  
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
       // Here total number of provinces are nothing but total connected components
       int n = isConnected.length;  
       boolean[] v = new boolean[n];
       int count = 0; 
       // start with 0th city - try to get number of starting nodes
       for (int i = 0; i < n; i++) {
         if(v[i] != true) {
             // if it is not visited earlier
             dfs(i, v, isConnected);
             count++;
         }  
       }
        
       return count;
    }
}
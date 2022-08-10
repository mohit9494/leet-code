class Solution {
    public int snakesAndLadders(int[][] board) {
        
        if (board == null || board.length == 0) return 0;
        // convert the board into flat array
        int n = board.length;
        int[] arr = new int[n*n + 1];
        int idx = 1, r = n - 1, c = 0, even = 0;
        
        while (idx < arr.length) {
            
            if (even % 2 == 0) {
                arr[idx] = board[r][c];
                c++;
                // switch
                if (c == n) {
                    r--;
                    c--;
                    even++;
                }
            } else {
                arr[idx] = board[r][c]; ;
                c--;
                // switch
                if (c == -1) {
                    r--;
                    c = 0;
                    even++;
                }
            }
            idx++;
        }
        
        System.out.println(Arrays.toString(arr));
        int count = 0;
        // Uisng BFS -> each node will cover max 6 child from 1 to 6
        // Just play with the index of arr
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        arr[0] = -2;
        arr[1] = -2; // visited
        
        while (!q.isEmpty()) {
            
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
             for (int j = 1; j <= 6; j++) {
                
                int child = curr + j;
                if (child == n * n) return count + 1;
                // if it is not visited previously
                if (arr[child] != -2) {
                    
                    if (arr[child] == -1) {
                        q.add(child);
                        arr[child] = -2;
                    } else {
                        // if (arr[child] > 0 like 15 or 30)
                        // This is very IMP :: Your Jump can be leading to destination
                        if (arr[child] == n * n) return count + 1;
                        q.add(arr[child]);
                        arr[child] = -2;
                    }
                    
                }
                
            }
            }           

            count++;
        }
        
        return -1;
    }
}
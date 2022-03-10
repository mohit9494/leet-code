// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static int helper(int N, int arr[], int sum, int[][] v) {

        
        if(sum == 0 ) return 1;
        if(N == 0) return 0;
        
        if (v[N][sum] != -1) {
            return v[N][sum];
        } 
        
        if(arr[N-1] > sum) {
            return v[N][sum] = helper(N-1, arr, sum, v);
        }
        else {
            return v[N][sum] = helper(N-1, arr, sum - arr[N-1],v) | helper(N-1, arr, sum,v);
        }
    }


    static boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        // boolean[][] t = new boolean[N+1][sum+1];
        int[][] visited =new int[N+1][sum + 1];
        
        // Initialize the array with -1;
        for(int i = 0 ; i < N + 1 ; i++) {
            for(int j = 0; j < sum + 1; j++){
                visited[i][j] = -1;
            }
        }
        
        
        
       int k = helper(N, arr, sum, visited);
       
       return k == 0 ? false : true; 
    }
}
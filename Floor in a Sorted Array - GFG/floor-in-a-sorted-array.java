// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           System.out.println(new Solution().findFloor(arr, n, x));
          
        }
    }
    
}// } Driver Code Ends


class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        
        // floor of x
        int left = 0;
        int right = arr.length - 1;
        
        if (x > arr[right]) return right;
        if (x < arr[left]) return -1;
        
        while (left <= right) {
            
            int mid = left + (right - left)/2;
            
            if (arr[mid] == x) return mid;
            else if (arr[mid] < x) left = mid + 1;
            else right = mid - 1;
            
        }
        
        return right;
    }
    
}

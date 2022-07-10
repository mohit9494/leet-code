class Solution {
    public int peakIndexInMountainArray(int[] arr) {
     
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            
            int mid = left + (right - left)/2;
            int a = mid - 1 >= 0 ? arr[mid - 1] : Integer.MIN_VALUE;
            int b = mid + 1 <= arr.length - 1 ? arr[mid + 1] : Integer.MIN_VALUE;
            
            if (arr[mid] > a && arr[mid] > b) return mid;
            
            if (arr[mid] < b) left = mid + 1;
            else right = mid - 1;
            
            
        }
        
        return -1;
        
    }
}
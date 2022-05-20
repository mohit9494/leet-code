class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int left = 1;
        int right = arr.length - 2;
        
        while(left <= right) {
           
            int mid = left + (right - left)/2;
            
            int leftElement = arr[mid - 1];
            int rightElement = arr[mid + 1];
            
            if(arr[mid] > leftElement && arr[mid] > rightElement) {
                return mid;
            } else if (leftElement > arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        
        return -1;
    }
}
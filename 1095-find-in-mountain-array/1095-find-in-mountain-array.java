/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    
    public int search(int target, MountainArray mountainArr, int left, int right) {
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            int val = mountainArr.get(mid);
            
            if (val == target) return mid;
            else if (val < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
        public int searchReverse(int target, MountainArray mountainArr, int left, int right) {
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            int val = mountainArr.get(mid);
            
            if (val == target) return mid;
            else if (val < target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        // get the peak in this Bitonic Array
        int left = 1;
        int right = mountainArr.length() - 2;
        int peak = 0;
        
        while (left <= right) {
            
            int mid = left + (right - left)/2;
            int le = mountainArr.get(mid - 1);
            int re = mountainArr.get(mid + 1);
            
            if(mountainArr.get(mid) > le && mountainArr.get(mid) > re) {
                peak = mid;
                break;
            } else if (le > mountainArr.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // Search in 2 search spaces using Binary Search
        int i = search(target, mountainArr, 0, peak);
        int j = searchReverse(target, mountainArr, peak + 1, mountainArr.length() - 1);
        
        if (i == -1 && j == -1) return -1;
        
        if (i != -1 && j != -1) return Math.min(i, j);
        
        if (i == -1) return j;
        else return i;
        
    }
}
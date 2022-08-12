class Solution {
    public int lengthOfLIS(int[] nums) {
        
        // This is Based on Binary Search :: Creating effective array which is monotonically increasing
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int j = 1;
        
        for (int i = 1; i < n; i++) {
            // compare value at i and j
            if (nums[i] > arr[j - 1]) {
                // just add in arr -> increasing sequence 
                arr[j] = nums[i];
                j++;
            } else {
                // find the proper place to insert/replace the nums[i] in effective array using BS
                int bi = BinarySearch(arr, 0, j-1, nums[i]);
                System.out.println(bi);
                arr[bi] = nums[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        // return length of effective array as ans;
        return j;
    }
    
    private int BinarySearch(int[] nums, int low, int high, int target) {
        
        while (low <= high) {
           
            int mid = low + (high - low)/2;
            
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target ) high = mid - 1;
            
        }
     return low;
    }
}
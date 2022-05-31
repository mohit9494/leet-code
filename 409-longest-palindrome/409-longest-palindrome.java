class Solution {
    public int longestPalindrome(String s) {
        
        int[] a = new int[256];
        int count = 0;
        boolean flag = true;
        
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)]++;
        }
        
        // Get count by dividing and multiply with 2 -> ccc
        for (int i : a) {
           count = count + ((i/2) * 2);
        }
        
        System.out.println(count);
        
        // Handling odd occurances
        return count == s.length() ? count : count + 1;
        
    }
}
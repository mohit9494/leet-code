/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int sum = Integer.MIN_VALUE;
    
    private int helper(TreeNode root) {
        
        if(root == null) return 0;
        
        // Ignore all the negative path and replace with 0 as it reduces the weight of current              //path
        int leftSum = Math.max(0, helper(root.left));
        int rightSum = Math.max(0, helper(root.right));
        
        sum = Math.max(sum, leftSum + rightSum + root.val);
        
        return root.val + Math.max(leftSum, rightSum);
    }
    
    public int maxPathSum(TreeNode root) {
        
        helper(root);
        
        return sum;
    }
}
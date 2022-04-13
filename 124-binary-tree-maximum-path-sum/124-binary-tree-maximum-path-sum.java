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
    
    int maxi = Integer.MIN_VALUE;
    
    private int helper(TreeNode root) {
        
        if(root == null) return 0;
        
       int leftSum =  Math.max(0, helper(root.left));
       int rightSum = Math.max(0, helper(root.right));
        
        maxi = Math.max(maxi, leftSum + rightSum + root.val);
        
        return root.val + Math.max(leftSum, rightSum);
    }
    
    public int maxPathSum(TreeNode root) {
        
        helper(root);
        return maxi;      
        
    }
}
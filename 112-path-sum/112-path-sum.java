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
    
    private boolean helper(TreeNode root, int targetSum) {
        
        if (root == null) return false;
        
        targetSum = targetSum - root.val;
        
        if (root.left == null && root.right == null) {
            if (targetSum == 0) return true;
            else return false;
        } 
        
        boolean l = helper(root.left, targetSum);
        boolean r = helper(root.right, targetSum);
        
        return l || r;
        
    } 
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return helper(root, targetSum);
        
    }
}
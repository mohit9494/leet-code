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
    
    private int getHeight(TreeNode root) {
        
        if (root == null) return 0;
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        return 1 + Math.max(lh, rh);
        
    }
    
    public boolean isBalanced(TreeNode root) {
        
        if (root == null) return true;
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        if (Math.abs(lh - rh) > 1) return false;
        
        if(!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        };
        
        return true;
        
        
    }
}
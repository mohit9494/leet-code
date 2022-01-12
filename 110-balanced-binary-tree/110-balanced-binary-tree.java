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

    
    private int depth(TreeNode root) {
        
        if(root == null) return 0;
        
        int ld = depth(root.left);
        if(ld == -1) return -1;
        
        int rd = depth(root.right);
        if(rd == -1) return -1;
        
        if(Math.abs(ld - rd) > 1) return -1;
            
        return 1 + Math.max(ld, rd);
        
    }
    
    public boolean isBalanced(TreeNode root) {
        
        // Tree is balanced if it doen't have -1 depth
        return depth(root) != -1;
        
    }
}
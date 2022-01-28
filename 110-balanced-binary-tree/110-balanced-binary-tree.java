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
    
    private int getHeight(TreeNode node) {
        
    if(node == null) return 0;
        
    int lh  = getHeight(node.left);
    if(lh == -1) return -1;
        
    int rh = getHeight(node.right);
    if(rh == -1) return -1;
        
    if(Math.abs(lh - rh) > 1 ) return -1;
        
    return 1 + Math.max(lh, rh);        
        
    }
    
    public boolean isBalanced(TreeNode root) {
        
        if (root == null) return true;
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        if(lh == -1 || rh == -1) return false;
        
        if(Math.abs(lh - rh) > 1 ) return false;
        
        return true;
        
    }
}
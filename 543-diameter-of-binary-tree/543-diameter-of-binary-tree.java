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
    
    private int getHeight(TreeNode root) {
        
        if (root == null) return 0;
        
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        maxi = Math.max(maxi, lh + rh);
        
        return 1 + Math.max(lh,rh);
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        if (root == null) return 0;
        
        getHeight(root);   
        
         return maxi;   
        
    }
}
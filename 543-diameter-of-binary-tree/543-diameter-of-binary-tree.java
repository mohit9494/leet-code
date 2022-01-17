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
    
    int max = 0;
    
    private int heightHelper(TreeNode root) {
        
        if(root == null) return 0;
        
        int lh = heightHelper(root.left);
        int rh = heightHelper(root.right);
        
        max = Math.max(max, lh + rh) ; 
        
        return Math.max(lh,rh) + 1;
        
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        
        heightHelper(root);
        return max ; 
        
    }
}
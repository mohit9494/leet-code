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
    
    private int heightHelper(TreeNode root) {
        
       if (root == null) return 0 ;
        
       int lh = heightHelper(root.left);
        int rh = heightHelper(root.right);
         
        return  Math.max(lh,rh) + 1;
}
    
    public boolean isBalanced(TreeNode root) {
        
        
        
       if(root == null) return true; 
        
        int lh = heightHelper(root.left);
        int rh = heightHelper(root.right);
        
        if(Math.abs(lh - rh) > 1) return false;
        
        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);
        
        if(!l || !r) return false;
        else return true;
        
        
    }
    
    
}
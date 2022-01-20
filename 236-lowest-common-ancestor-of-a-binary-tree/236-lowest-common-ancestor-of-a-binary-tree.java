/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // This is flag problem
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        
     if (root == null) return null;   
        
     if (root == p || root == q) return root;
       
     TreeNode lh = helper(root.left, p,q); 
        
        TreeNode rh = helper(root.right, p,q);
        
        if(lh == null && rh == null) return null;
        
        if(lh != null && rh != null) return root;
        
        if(lh != null) return lh;
        else return rh;
        
        
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return helper(root, p , q);
        
    }
}
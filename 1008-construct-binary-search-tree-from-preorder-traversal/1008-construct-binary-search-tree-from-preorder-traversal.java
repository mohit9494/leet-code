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
    
    int ni = 0;
    
    private TreeNode bstHelper(int[] preorder, int min, int max) {
        
        if (ni == preorder.length || 
            preorder[ni] < min || preorder[ni] > max) return null;
        
     int val = preorder[ni++];
        
    TreeNode root = new TreeNode(val);
     
    root.left = bstHelper(preorder, min, root.val);
    root.right = bstHelper(preorder, root.val, max);
        
    return root;  
        
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        
        if(preorder == null) return null;
        
        return bstHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        
        
    }
}
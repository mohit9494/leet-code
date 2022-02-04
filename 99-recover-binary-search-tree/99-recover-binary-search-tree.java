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
    
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev;
    
    public void inorder(TreeNode root) {
        
        if (root == null) return;
        
        inorder(root.left);
        
        // violation
        if (root.val < prev.val) {
            
            // first and second violation
            if(first == null) {
                first = prev;
                middle = root;
            } else {
                
             last = root; 
            }
            
        }
        
        prev =  root;
        inorder(root.right);
        
    }
    
    public void recoverTree(TreeNode root) {
        
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        
        inorder(root);
        
        if(first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
            
        } else {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
        
    }
}
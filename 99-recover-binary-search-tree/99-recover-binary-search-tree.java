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
        
    private void inorder(TreeNode root) {
        
        if (root == null) return;
        
        inorder(root.left);
        
        // Violation -> Process
        if(prev.val > root.val) {
            
            if(first == null) {
                // First Violation
                first = prev;
                middle = root;
            } else {
                // second violation
                last = root;
            }
            
        }
        
        prev = root;
        
        inorder(root.right);
        
        
    }
    
    public void recoverTree(TreeNode root) {
        
        if(root == null) return;
        
        first = middle = last = null;
        
        prev = new TreeNode(Integer.MIN_VALUE);
        
        inorder(root);        
        
        // Swapping the nodes;
        if(first != null && last != null) {
            
            int t = first.val;
            first.val = last.val;
            last.val = t;
            
        } else {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
        
        
    }
}
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
    
    public int getLeftHeight(TreeNode root) {
        int count =0;
        
        while(root.left != null) {
            root = root.left;
            count++;
        }
        
        return count;
    }
    
    public int getRightHeight(TreeNode root) {
        
      
        int count = 0;
        
        while(root.right != null) {
            root = root.right;
            count++;
        } 
        
        return count;
    }
    
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
        
    }
}
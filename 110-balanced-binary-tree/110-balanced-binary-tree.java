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
      
     if (root == null) return 0;
     
     int left = depth(root.left);
     if(left == -1) return -1;
      
     int right = depth(root.right);
     if(right == -1) return -1;
      
     if(Math.abs(left - right) > 1 ) return -1 ; 
     
    return 1 + Math.max(left,right);
      
      
      
  }
    
    
    
    public boolean isBalanced(TreeNode root) {
        
        
       // If it doesn't return -1 then it is balanced
        return depth(root) != -1;
        
        
        
    }
}